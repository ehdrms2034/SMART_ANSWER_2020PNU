import re
import requests
import urllib.request
import json
import io
import os
from datetime import datetime

#오늘 년월일
today=str(datetime.today().strftime("%Y-%m-%d"))
txt = os.path.splitext('./test.txt')[1]

#서버에서 OCR에 이용할 사진 파일 저장
lv2_data_json_url = 'http://54.180.175.238:8080/api/upload/files'
response = requests.get(lv2_data_json_url)
json_string = response.text

course_list2 = json.loads(json_string)
list = course_list2['data']
url = list[0]
urllib.request.urlretrieve(url, '.\word_img'+'/'+str(today)+'.jpg')

#OCR
from google.cloud import vision
from google.cloud.vision import types

client = vision.ImageAnnotatorClient()
filenames = os.listdir('./word_img')

for filename in filenames:
    path = os.path.join('./word_img', filename)

    with io.open(path, 'rb') as image_file:
        content = image_file.read()

    image = vision.types.Image(content=content)
    response = client.text_detection(image=image)
    texts = response.text_annotations

    with open('./word_txt/'+filename[0:-4]+'.txt', "w",-1,"utf-8") as f:
        f.write(texts[0].description)

#채점 및 틀린 단어 저장
#추출한 파일에서 쓸모 없는 단어 제거
INPUT_FILE_NAME1 = './word_txt'+'/'+str(today)+str(txt)
OUTPUT_FILE_NAME1 = './removefile'+'/'+str(today)+'K'+str(txt)

def clean_textE(text):
    cleaned_textE = re.sub('[a-zA-Z]' , '', text)
    cleaned_textE = re.sub('[0-9]', '', cleaned_textE)
    cleaned_textE = re.sub('단어 시험', '', cleaned_textE)
    cleaned_textE = re.sub('[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]',
                          '', cleaned_textE)
    cleaned_textE = re.sub(' ', '', cleaned_textE)
 
    return cleaned_textE

def main():
    read_file = open(INPUT_FILE_NAME1, 'r',-1,"utf-8")
    write_file = open(OUTPUT_FILE_NAME1, 'w',-1,"utf-8")
    text = read_file.read()
    text = clean_textE(text)
    write_file.write(text)
    read_file.close()
    write_file.close() 
 
if __name__ == "__main__":
    main()
 
INPUT_FILE_NAME2 = '.\word_txt'+'/'+str(today)+str(txt)
OUTPUT_FILE_NAME2 = './removefile'+'/'+str(today)+'E'+str(txt)

korean = re.compile('[\u3131-\u3163\uac00-\ud7a3]+')


def clean_textK(text):
    cleaned_textK = re.sub(korean, '', text)
    cleaned_textK = re.sub('[0-9]', '', cleaned_textK)
    cleaned_textK = re.sub('[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]',
                          '', cleaned_textK)
    cleaned_textK = re.sub(' ', '', cleaned_textK)
 
    return cleaned_textK

def main():
    read_file = open(INPUT_FILE_NAME2, 'r',-1,"utf-8")
    write_file = open(OUTPUT_FILE_NAME2, 'w',-1,"utf-8")
    text = read_file.read()
    text = clean_textK(text)
    write_file.write(text)
    read_file.close()
    write_file.close() 
 
if __name__ == "__main__":
    main()


#단어 채점
fK = open('./removefile'+'/'+str(today)+'K'+str(txt), 'r',-1,"utf-8")
fE = open('./removefile'+'/'+str(today)+'E'+str(txt), 'r',-1,"utf-8")
fA = open('./word_txt'+'/'+str(today)+'answer'+str(txt),'rt', encoding='UTF8')

lineK = fK.readline()
lineE = fE.readline()

wword=[]
wmean=[]
aword=[]
amean=[]
aaword=[]
aamean=[]
i=0
a=0
b=0
t=0
c=0

while True:
    lineK = fK.readline()
    lineA = fA.readline()
    lineE = fE.readline()
    if lineK != lineA:
        wword.insert(a, lineE.rstrip())
        wmean.insert(a, lineA.rstrip())
        a=a+1
    if lineK == lineA:
        aword.insert(b, lineE.rstrip())
        amean.insert(b, lineA.rstrip())
        b=b+1
    if not lineK: break
    i=i+1
    t=t+1
c=t-a
aaword = [x for x in aword if x]
aamean = [x for x in amean if x]

fK.close()
fE.close()
fA.close()

#틀린 단어 데이터 전송
data = {
  "answer_count": c,
  "correct_word": aaword,
  "date": today,
  "mean_word": wmean,
  "my_word": wword,
  "owner": "tjr99382",
  "wrong_count": a
}
r = requests.post('http://54.180.175.238:8080/api/wrong/inputWrongAnswer',json=data)
print(r.text)
