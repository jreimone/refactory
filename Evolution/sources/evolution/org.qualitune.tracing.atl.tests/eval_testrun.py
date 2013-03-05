#!/bin/env python

# @author: Fabian Haensel <fabtagon@gmx.de>
# @date: Di 26. Feb 13:11:56 CET 2013

"""Reads test results from file test.log, evaluates them and summarises results (to stdout)."""

def prompt_mismatch(test_name, expected_output_buffer, actual_output_buffer):
	print '\n\nTest failure for test case',test_name
	print
	print 'Expected result:'
	for line in expected_output_buffer:
		print line
	print
	print 'Actual result:'
	for line in actual_output_buffer:
		print line
	

def identical(bufferA, bufferB):
	n = len(bufferA)
	m = len(bufferB)
	
	if (n != m):
		return False;
	
	for i in range(0,n):
		if (bufferA[i] != bufferB[i]):
			return False;
	
	return True;

def examine_test(test_name, expected_output_buffer, actual_output_buffer):
	if (identical(expected_output_buffer, actual_output_buffer)):
		successful_tests.append(test_name);
	else:
		prompt_mismatch(test_name, expected_output_buffer, actual_output_buffer)
		failed_tests.append(test_name);

def present_summary():
	n_success = len(successful_tests)
	n_failed  = len(failed_tests)
	n = (n_success + n_failed)
	print
	print 'Testrunner summary'
	print '=================='
	print n, 'tests have been run,', n_success, 'were successful whereas', n_failed, 'have failed (', (100.0*n_success/n), '% success rate)'

	print
	print 'successful tests:'
	for test_name in successful_tests:
		print test_name

	print
	print 'failed tests:'
	for test_name in failed_tests:
		print test_name


#path='-' # stdin
path = 'testrun.log'

# modes
PARSE_FOR_TESTCASE_BEGIN = 1
RECORD_EXPECTED_OUTPUT = 2
RECORD_ACTUAL_OUTPUT = 3

successful_tests = []
failed_tests = []

mode = PARSE_FOR_TESTCASE_BEGIN

f = open(path,'r')

for line in f.readlines()[1:-1]:
	line = line.strip()
	#print '#',mode,line
	if (mode == PARSE_FOR_TESTCASE_BEGIN):
		word = line.split(' ')
		command = word[0]
		if ((command == '') or (command == 'msg')):
			continue # ignore
		elif (command == 'testcase_begin'):
			test_name = word[1]
			mode = RECORD_EXPECTED_OUTPUT
			expected_output_buffer = []
		else:
			print 'unknown command in log:', command,
		
	elif (mode == RECORD_EXPECTED_OUTPUT):
		if (line != 'above_was_expected_output_now_comes_actual_output'):
			expected_output_buffer.append(line);
		else:
			mode = RECORD_ACTUAL_OUTPUT
			actual_output_buffer = []

	elif (mode == RECORD_ACTUAL_OUTPUT):
		if (line != 'testcase_end'):
			actual_output_buffer.append(line);
		else:
			examine_test(test_name,expected_output_buffer,actual_output_buffer)
			mode = PARSE_FOR_TESTCASE_BEGIN

present_summary()
