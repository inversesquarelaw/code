
myStr = '0123456789    The quick   brown   fox    jumps over the lazy    dog.  '
print('original:\n%s' % myStr)

newStr = myStr[::-1]          #doing it the idiomatic python way (easy)
print('reverse:\n%s' % newStr)


#doing it the C-style way (harder)

def reverse(someStr):
  lst = []
  count = 1

  for i in range(0, len(someStr)):    #using range to count from 0 to len(str)
    lst.append(someStr[len(someStr) - count]) #get char at idx len minus count
    count += 1

  lst = ''.join(lst)
  return lst
#end reverse

def reverse2(someStr):      #using xrange to count backwards from len(str) to 0
  lst = []

  for i in xrange(len(someStr)-1, -1, -1):
    lst.append(someStr[i])

  lst = ''.join(lst)
  return lst
#end reverse2

def reverse3(someStr):    #reverse using recursion
  if len(someStr) <= 1:
    return someStr

  return reverse3(someStr[1:]) + someStr[0]
#end reverse3


print('reverse (harder way):\n%s' % reverse(myStr))
print('reverse2 (harder way):\n%s' % reverse2(myStr))
print('reverse3 (harder way):\n%s' % reverse3(myStr))
