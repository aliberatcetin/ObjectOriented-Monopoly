import requests
import urllib

import urllib.request
from bs4 import BeautifulSoup
import re
from bs4.dammit import EncodingDetector
from html.parser import HTMLParser
import PyPDF2
import os
import re
import math
import operator
from xlwt import Workbook
from wordcloud import WordCloud



stopwords = open("stopwords.txt", "r").read().split()

'''
url="https://muratcanganiz.com/"


def insert_dash(string, index,item):
    return string[:index] + item + string[index:]

def remove_char(string ,index1,index2):
	return string[:index1] + string[index2:]

htmlContent = urllib.request.urlopen(url).read()

html = htmlContent

soup = BeautifulSoup(html,"lxml",from_encoding="utf-8")

links=[]
for a in soup.findAll('a', href=True):
   	links.append(a['href'])

i=0

file = open("testfile.txt","w")


pdfLinks=[]

while i < len(links):
    if(links[i].count('pdf')>=1):
    	o=0
    	flag=1
    	while o < len(links[i]):
    		if( ord(links[i][o])>200 ):
    			flag=0
    		o+=1
    	if(flag==1):
    		pdfLinks.append(links[i])
    	flag=1
    i+=1

j=0

c=0
while c< len(pdfLinks):
	print(pdfLinks[c])
	c+=1

file.close()


while j< len(pdfLinks):
	currentUrl = url+pdfLinks[j]
	currentUrl=currentUrl.replace(' ','%20')
	print(currentUrl)
	#currentUrl=currentUrl.decode('utf-8')
	if(currentUrl.count('publications')>=1):
		urllib.request.urlretrieve(currentUrl,pdfLinks[j])
	j+=1


'''

def splitText(string):
    '''stripped = re.sub('[^\w\s','',string)
    stripped = re.sub('_','',stripped)

    stripped = re.sub('\s+','',stripped)

    stripped = stripped.strip()'''
    splitted = re.findall(r"[\w']+", string)

    return splitted


articles = []
articleNames = []
text = ""
for filename in os.listdir('./publications'):
    file = open('./publications/'+filename, 'rb')
    articleNames.append(filename)
    fileReader = PyPDF2.PdfFileReader(file)
    numpages = fileReader.numPages
    text=""
    for k in range(numpages):
        page = fileReader.getPage(k)
        text+= page.extractText()
    
    articles.append(text)
    


def freqDictList(text):
    for word in text:
        print(word)

i=0
freqDict_list = []

totalTerm={}
for k in range(len(articles)):
    cleanText = []
    SplittedText = splitText(articles[k])
    i+=1
    for k in SplittedText:
        if not k.isdigit() and not len(k) < 2:
            k = k.lower()
            if k not in stopwords:
                cleanText.append(k)
    freq_dict = {}
    for word in cleanText:
        word=word.lower()
        if word in freq_dict:
            freq_dict[word]+=1
        else:
            freq_dict[word]=1 
        if word in totalTerm:
            totalTerm[word]+=1
        else:
            totalTerm[word]=1        
    freqDict_list.append(freq_dict)


sorted_x=[]
for k in range(len(freqDict_list)):
    a = sorted(freqDict_list[0].items(), key=operator.itemgetter(1),reverse=True)
    sorted_x.append(a);


wb = Workbook()
excelIndex=0
sheet1 = wb.add_sheet('tf')


excelRow=0
excelCol=0
for k in range(50):
    sheet1.write(excelRow, 0,sorted_x[0][k][0])
    sheet1.write(excelRow, 1,sorted_x[0][k][1])
    excelRow+=1


imagelist=[]
freq_ToImg = {}
for k in range(50):
    freq_ToImg[sorted_x[0][k][0]]=sorted_x[0][k][1]



#imagelist.append(freq_ToImg)

def makeImage(text,flag):
    wc = WordCloud(background_color="white", max_words=50, max_font_size=50, width=480, height=270).generate_from_frequencies(text)
    image = wc.to_image()
    if flag == 1:
        image.save("tf_WordCloud.pdf")
    else:
        image.save("tfidf_WordCloud.pdf")


tfidf = {}



#makeImage(freq_ToImg,1)


wb.save('ds.csv')
