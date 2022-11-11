main: #this main directive will take out test and change it for a main program flow file; NEED to make test directive
	javac Fraction.java GaussianElimination.java Test.java DisplayRowReducedMatrix.java Determinant.java

clean:
	rm *.class