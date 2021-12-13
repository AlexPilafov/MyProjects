import sys

filename = sys.argv[1]
output_filename = sys.argv[2]

items = list()
with open(filename) as fin:
    for line in fin:
        items.append(line.strip())

items.sort()

with open(output_filename, 'w') as fout:
    for item in items:
        fout.write(item + '\n')