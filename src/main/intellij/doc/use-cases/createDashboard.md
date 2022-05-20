# Create edu.vassar.cmpu203.schmoodleproto1.Model.Dashboard
## Scope
Social  Network Application
## Level
User goal
## Primary Actor
User
## Stakeholders and Interests
### Vassar Student or Faculty
User wants to be able to connect with other students or faculty and
be regularly updated on the happenings of campus via dashboards.

## Preconditions
User is a Vassar student or is Vassar faculty.

## Postconditions
1. User is logged into application
2. User is currently on the homepage

## Main Success Scenario
1. User is on the homepage.
2. User clicks the Create edu.vassar.cmpu203.schmoodleproto1.Model.Dashboard button.
3. User fills in the slot for dashboard name, dashboard contents, and PIN.
4. User clicks submit.
5. The data is added to the database.
6. Success message is displayed, and the user is
   taken back to the homescreen.

## Extensions
### 3a. Inputs edu.vassar.cmpu203.schmoodleproto1.Model.Dashboard Name
1. User clicks the dashboard name slot. 
2. User types in the name they want.
3. Upon submitting, the system adds the data to the database.
### 3b. Inputs edu.vassar.cmpu203.schmoodleproto1.Model.Dashboard Contents
1. User clicks the dashboard contents slot.
2. User types in the contents they want.
3. Upon submitting, the system adds the data to the database.
### 3c. Inputs PIN
1. User clicks the dashboard PIN slot.
2. User types in a 4 digit PIN.
3. Upon submitting, the system adds the data to the database.
### 3d. Selects Cancel
1. User clicks on the cancel button.
2. User is taken back to the homescreen.
### 4a. Invalid Inputs
1. User clicks on the submit button.
2. User has not submitted enough data in the required slots.
3. A message is shown saying that the user has not inputted enough information,
   and will highlight the slots that need to be filled.
### a. System crashes.
1. User closes application.
2. User reopens application and restarts the operations.
## Special Requirements
1. Android version 5.0 or more recent.
2. Touch screen.