""" 
bubble sort implemenation in python

this program will generate the specified number of elements with random numbers within the range of elements
it will print the generated list and then print the sorted list after bubble sort

by Dustin D'Avignon
"""
import random

# number of elements
ELEMENTS = 10

# create a list of random numbers that need to be sorted
numbers_to_sort = range(ELEMENTS)
for x in range (0,ELEMENTS):
	numbers_to_sort[x] = random.randint(1,ELEMENTS)

# print numbers in list
print "\nnumbers BEFORE sorting:\n", numbers_to_sort, "\n"

# good ol bubble sort
for i in range (0,ELEMENTS):
	for j in range (0,ELEMENTS):
		if numbers_to_sort[i] < numbers_to_sort[j]:
			numbers_to_sort[i], numbers_to_sort[j] = numbers_to_sort[j], numbers_to_sort[i]

# printed sorted numbers
print "numbers AFTER sorting:\n", numbers_to_sort, "\n"