package springbook.learningtest.template

def lineFile = new File(getClass().getResource("numbers.txt").getPath())

def sumValue = 0, multiflyValue = 1, concateValue = ''

lineFile.eachLine {
	sumValue += Integer.parseInt(it)
	multiflyValue *= Integer.parseInt(it)
	concateValue += it
}

assert sumValue == 10
assert multiflyValue == 24
assert concateValue == '1234'