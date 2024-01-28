# Model-driven software engineering project

This is the project developed for the final exam of the course "Progettazione Model Driven del Software".

## A software application to manage internships

### Functional requirements

* A student must be able to fill out a request to activate an internship, which can be internal or external.
* The student must be able to indicate the title of the internship.
* The student must be able to indicate the personal data of himself/herself, the supervisor, and any co-supervisors.
* The student must be able to indicate the start date and end date of the internship.
* In the case of an external internship, the student must be able to indicate the data of the company where he/she intends to carry out the internship.
* The student must be able to upload a PDF file containing the self-certification of the exams taken.
* The student must have the possibility, directly from the internship activation request form, to navigate to the self-certification service to generate the document required by the system.
* The student must receive an email notification when his/her internship request has been approved by both the supervisor and the internship commission.
* The student must be able to check the status of the internship. If the internship is in progress, the time elapsed since the approval date must be displayed.
* The supervisor must receive an email notification when a student fills out an internship request in which he/she appears as the supervisor.
* The supervisor must be able to view the data relating to all the internships in which he/she is involved and the status of each internship.
* The supervisor must be able to approve or reject an internship request.
* The supervisor must be able to modify the data relating to an internship that has already been approved.
* The supervisor must be able to terminate an internship.
* The internship commission must be able to view the data relating to all the internships approved by the supervisors.
* The internship commission must be able to approve or reject an internship request.

### Non-functional requirements

* The student must be able to activate an internship only if he/she has already passed all the compulsory exams of the first two years, or has acquired at least 120 ECTS and still has to pass at most one exam among those compulsory in the first two years.
* The student must indicate one and only one supervisor, and from zero to two co-supervisors.
* The supervisor must be able to terminate an internship only if the end date of the internship has been reached or exceeded.
* The internship must last at least 14 weeks and no more than 24.
* The supervisor is necessarily a university professor.
* If the internship is external, an external tutor must be indicated in addition to the academic supervisor.
* A professor who is a member of the internship commission cannot approve an internship of which he/she is the academic supervisor.
* The co-supervisor is not to be considered a system user as he/she cannot perform any operation on the internship request.
* If the supervisor or the internship commission rejects the internship proposal, the student must start the procedure over from the beginning. The data of the rejected proposal are not saved.

### Development requirements

* The system must be developed in the Java programming language.
* The graphical user interface must be developed with JavaFX.
* Persistent data must be managed with a relational database. Access to the database must be performed with the JDBC library.

