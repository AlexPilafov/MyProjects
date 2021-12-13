import sys

def main(argv):	
	a = int(sys.argv[1])
	b = int(sys.argv[2])
	sum = 0
	
	for i in range(a):
		sum = a**b
		
	print (str(sum))

if __name__ == "__main__":
	main(sys.argv[1:])