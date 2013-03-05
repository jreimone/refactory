#!/bin/env python

# @author: Fabian Haensel <fabtagon@gmx.de>
# @date: Di 26. Feb 13:11:56 CET 2013

"""Merges test cases and ATL VAPODI runtime base stub to an executable test suite (which
can be assessed using testeval.py).

Basically four parts:
   1. copy in ATL base stub (vapodi_base_stub.atl)
   2. copy in testcases.atl
   3. copy in test_infrastructure.atl
   4. create test suite rule calling test cases from test_cases.atl
   (mind to change module definition, specifically regarding input/output)
"""

#outpath='-' # stdin
out_path = 'test_suite.atl'

basestub_path = '../org.qualitune.tracing/atl_lib/vapodi_base_stub.atl'
testcases_path = 'test_cases.atl'
testinfrastructure_path = 'test_infrastructure.atl'

"""returns array containing all names of all test cases defined in file testcases_path"""
def get_test_cases( ):

	test_cases = [];
	
	for line in open(testcases_path,'r').readlines():
		splitted_line = line.strip().split(' ')
		if (splitted_line[0] == 'rule'):
			rule_name = splitted_line[1].split('(')[0]
			test_cases.append(rule_name);

	return test_cases;



"""produces entrypoint rule running the test suite"""
def create_test_suite(outfile):

	all_test_cases = get_test_cases()
	n_test_cases = str(len(all_test_cases))

	outfile.write("""-- starting auto-generated entrypoint rule
	
	entrypoint rule test_runner () {
	do {
		'msg Hi, I \\'m the test runner and I\\'m going to run """ + n_test_cases + """ tests\\n'.println();
		
		thisModule.fail_softly <- true;""")
	
	
	for test_case in all_test_cases:
		outfile.write("""thisModule.reset_datastructures();
		'testcase_begin """ + test_case + """'.println();
		thisModule.""" + test_case + """();
		'testcase_end\\n'.println();
		
		""")

	outfile.write("'msg Hi, I\\'m the test runner and I\\'ve just finished running " + n_test_cases + """ tests'.println();
	}
}""")

"""copies contents of file in_path into outfile, optionally skipping a number of lines"""
def copy_in(in_path,outfile,skip=0):
	outfile.write('-- starting part copied from ' + in_path + '\n\n')
	in_file = open(in_path,'r')
	to_skip = skip
	for line in in_file.readlines():
		if (to_skip == 0):
			outfile.write(line)
		else:
			to_skip -= 1
		
	outfile.write('\n\n')


outfile = open(out_path, 'w')

outfile.write("""--- WARNING: THIS FILE IS GENERATED - do not alter, as your changes will likely get overwritten
module VapodiTestRunner;
create OUT : Persons, VAPODI_TRACE : VAPODI_TRACE_METAMODEL from IN : Families;

""")
copy_in(basestub_path,outfile,2)
copy_in(testcases_path,outfile,2)
copy_in(testinfrastructure_path,outfile,2)
create_test_suite(outfile)

outfile.close()
