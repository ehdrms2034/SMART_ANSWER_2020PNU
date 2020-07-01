import requests
import json

data = {
  "date": "2020-06-23",
  "id": "tjr99382"
}
r = requests.post('http://54.180.175.238:8080/api/answer/getAnswerInfo',json=data).text
print(r)
