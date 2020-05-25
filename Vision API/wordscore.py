import re
 
INPUT_FILE_NAME1 = 'word_txt\word test1.txt'
OUTPUT_FILE_NAME1 = 'removefile\word test1K.txt'

def clean_textE(text):
    cleaned_textE = re.sub('[a-zA-Z]' , '', text)
    cleaned_textE = re.sub('[0-9]', '', cleaned_textE)
    cleaned_textE = re.sub('단어 시험', '', cleaned_textE)
    cleaned_textE = re.sub('[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]',
                          '', cleaned_textE)
    cleaned_textE = re.sub(' ', '', cleaned_textE)
 
    return cleaned_textE

def main():
    read_file = open(INPUT_FILE_NAME1, 'r')
    write_file = open(OUTPUT_FILE_NAME1, 'w')
    text = read_file.read()
    text = clean_textE(text)
    write_file.write(text)
    read_file.close()
    write_file.close() 
 
if __name__ == "__main__":
    main()
 
INPUT_FILE_NAME2 = 'word_txt\word test1.txt'
OUTPUT_FILE_NAME2 = 'removefile\word test1E.txt'

korean = re.compile('[\u3131-\u3163\uac00-\ud7a3]+')


def clean_textK(text):
    cleaned_textK = re.sub(korean, '', text)
    cleaned_textK = re.sub('[0-9]', '', cleaned_textK)
    cleaned_textK = re.sub('[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]',
                          '', cleaned_textK)
    cleaned_textK = re.sub(' ', '', cleaned_textK)
 
    return cleaned_textK

def main():
    read_file = open(INPUT_FILE_NAME2, 'r')
    write_file = open(OUTPUT_FILE_NAME2, 'w')
    text = read_file.read()
    text = clean_textK(text)
    write_file.write(text)
    read_file.close()
    write_file.close() 
 
if __name__ == "__main__":
    main()



fK = open("removefile\word test1K.txt", 'r')
fE = open("removefile\word test1E.txt", 'r')
fA = open("word_txt\word answer.txt",'rt', encoding='UTF8')
fWM = open("data\worng answer.txt", 'w')

lineK = fK.readline()
lineE = fE.readline()

word=[0 for i in range(20)]
mean=[0 for i in range(20)]
listsum = [0 for i in range(20)]
i=0
a=0
t=0

while True:
    lineK = fK.readline()
    lineA = fA.readline()
    lineE = fE.readline()
    if lineK != lineA:
        word.insert(i, lineE)
        mean.insert(i, lineA)
        listsum.insert(i,word[i]+mean[i])
        fWM.write(listsum[i])
        a=a+1
    if not lineK: break
    i=i+1
    t=t+1
print(t-a,'/',t)
fK.close()
fE.close()
fA.close()
fWM.close()
