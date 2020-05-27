import io # 파일을 읽고 쓰기위한 모듈
import os # os의 기능을 사용하기 위한 모듈

# Imports the Google Cloud client library
from google.cloud import vision
from google.cloud.vision import types

client = vision.ImageAnnotatorClient()
filenames = os.listdir('./word_img') # book_img 아래에 있는 이미지 파일 이름을 불러오기

for filename in filenames:
    path = os.path.join('./word_img', filename)

    # Loads the image into memory
    with io.open(path, 'rb') as image_file:
        content = image_file.read()

    image = vision.types.Image(content=content)
    response = client.text_detection(image=image)
    texts = response.text_annotations

    with open('./word_txt/'+filename[0:-4]+'.txt', "w") as f:
        f.write(texts[0].description)
