# Patient-Health-Manager


# Patient Info Aggregator

This program reads patient and exam data from an input file and aggregates it to produce a summary for each patient. The program then writes the summary to an output file.

## Input Format

The input file contains a series of commands, one per line. Each command is of the form:


where `COMMAND TYPE` is one of `ADD` or `DEL`, `PATIENT/EXAM ID` is an integer, and `PATIENT/EXAM NAME` is a string. For `ADD` commands, the `PATIENT/EXAM NAME` field is required.

The following command types are supported:

- `ADD PATIENT [ID] [NAME]`: adds a new patient with the specified ID and name.
- `ADD EXAM [ID] [PATIENT ID]`: adds a new exam with the specified ID and associates it with the specified patient ID.
- `DEL PATIENT [ID]`: deletes the patient with the specified ID and all associated exams.
- `DEL EXAM [ID] [PATIENT ID]`: deletes the exam with the specified ID associated with the specified patient ID.

## Output Format

The output file contains one line per patient, with the following format:


where `[PATIENT NAME]` is the name of the patient, `[PATIENT ID]` is the ID of the patient, and `[EXAM COUNT]` is the number of exams associated with the patient.

## Building and Running

To build the program, simply run:


To run the program, specify the input file and output file as arguments:


## Testing

A test class `PatientInfoAggregatorTest.java` is provided to test the program. The test inputs and expected outputs are defined in the `input.txt` and `output.txt` files, respectively. To run the tests, simply run:


The program will run and compare the actual output to the expected output. If they match, the test will pass; otherwise, the test will fail.

