import sys
import json

filename = sys.argv[1]
word = sys.argv[2]

d = {}
with open(filename) as fh:
    for line in fh:
        key , value = line.strip().split(':', 1)
        d[key] = value.strip()

print(json.dumps(d, indent=2))

output = d.get(word)
print("Base form of the word: " + output)