# Create edu.vassar.cmpu203.schmoodleproto1.Model.Profile
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
1. edu.vassar.cmpu203.schmoodleproto1.Model.Profile is made.
2. Making a new profile was cancelled, return to home screen.

## Main Success Scenario
1. User opens application.
2. User, clicks the Create edu.vassar.cmpu203.schmoodleproto1.Model.Profile button on the log-in screen.
3. The user fills in the necessary categories (depends on role): name, role (student or faculty),
   year, major(s) and minor(s), classes taken, current classes,
   clubs/teams, personal bio, and a password.
4. The user submits the categories.
5. edu.vassar.cmpu203.schmoodleproto1.Model.Profile is added to the database, and the user continues
   to the homepage of the application.
## Extensions
### 3a. Inputs Name
1. User clicks on name slot.
2. User types in their name.
3. Upon submitting, the system adds the data to the database.
### 3b. Inputs Role
1. User clicks on role slot.
2. User selects role from a dropdown menu of student or faculty.
3. Upon submitting, the system adds the data to the database.
### 3c. Inputs Major(s)
1. User clicks on major(s) slot.
2. User types in their major from a dropdown menu.
3. Upon submitting, the system adds the data to the database.
### 3d. Inputs Minor(s)
1. User clicks on minor(s) slot.
2. User types in their minor(s) from a dropdown menu.
3. Upon submitting, the system adds the data to the database.
### 3e. Inputs Classes Taken:
1. User clicks on the classes taken slot.
2. User adds classes taken from a dropdown menu one at a time.
3. Upon submitting, the system adds the data to the database.
### 3f. Inputs Current Classes:
1. User clicks on the current classes slot.
2. User adds classes from a dropdown menu one at a time.
3. Upon submitting, the system adds the data to the database.
### 3g. Inputs Clubs/Teams:
1. User clicks on the clubs/teams slot.
2. User types in clubs/teams. 
3. Upon submitting, the system adds the data to the database.
### 3h. Inputs Personal Bio:
1. User clicks on the personal bio slot.
2. User types in their personal bio.
3. Upon submitting, the system adds the data to the database.
### 3i. Inputs Password:
1. User clicks on the password slot.
2. User types in a password.
3. Upon submitting, the system adds the data to the database.
### 3j. Selects Submit
1. User clicks on the submit button.
2. All slots' data is added to the database.
3. User is taken to the homepage.
### 3k. Selects Cancel
1. User clicks on the cancel button.
2. User is taken back to the log-in screen.
### 3l. Invalid Inputs
1. User clicks on the submit button.
2. User has not submitted enough data in the required slots.
3. A message is shown saying that the user has not inputted enough
   information, and will highlight the slots that need to be filled.
### a. System crashes.
1. User closes application.
2. User reopens application and restarts the operations.
## Special Requirements
1. Android version 5.0 or more recent.
2. Touch screen.


