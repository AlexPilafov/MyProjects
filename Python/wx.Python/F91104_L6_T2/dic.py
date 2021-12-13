import os, sys
import random,re

class AllWords:
    default_words = u"nicotine idol skin"

    def __init__(self, filename, min_length = 5):
        self.min_length = min_length
        filename = os.path.join(os.path.dirname(os.path.realpath(__file__)), filename)
        try:
            f = open(filename, "r")
        except:
            self.words = self.default_words
            self.filename = None
            return
        self.words = f.read()
        self.filename = filename

    def SetMinLength(min_length):
        self.min_length = min_length

    def Get(self):
        reg = re.compile('\s+([a-zA-Z]+)\s+')
        n = 30 
        while n:
            index = int(random.random()*len(self.words))
            m = reg.search(self.words[index:])
            if m and len(m.groups()[0]) >= self.min_length: break
            n = n - 1
        if n: return m.groups()[0].lower()
        return 'hangman' 