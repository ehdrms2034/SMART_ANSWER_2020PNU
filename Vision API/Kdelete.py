import re
 
INPUT_FILE_NAME = 'word_txt\word test1.txt'
OUTPUT_FILE_NAME = 'removefile\word test1E.txt'

korean = re.compile('[\u3131-\u3163\uac00-\ud7a3]+')


def clean_text(text):
    cleaned_text = re.sub(korean, '', text)
    cleaned_text = re.sub('[0-9]', '', cleaned_text)
    cleaned_text = re.sub('[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]',
                          '', cleaned_text)
    cleaned_text = re.sub(' ', '', cleaned_text)
 
    return cleaned_text

def main():
    read_file = open(INPUT_FILE_NAME, 'r')
    write_file = open(OUTPUT_FILE_NAME, 'w')
    text = read_file.read()
    text = clean_text(text)
    write_file.write(text)
    read_file.close()
    write_file.close() 
 
if __name__ == "__main__":
    main()
