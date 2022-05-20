# add Event
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
1.User is a Vassar student or is Vassar faculty.
2. User is logged into application
3. User is currently on the homepage

## Postconditions
1. User has added an event to their dashboard
2. Event is posted on their dashboard, and is able to be viewed on the bottom of their homepage

## Main Success Scenario
1. User is on the homepage.
2. User clicks the Make New Event button.  
3. Application loads the 'New Event' fragment screen
4. User fills in the new event's Title 
5. User fills in the new event's Contents
6. User clicks Post! button
7. The new event is added to the user's dashboard
8. Success message is displayed (snackbar showing the title of the new event)
9. User clicks Back button
10. Application loads the 'homepage' fragment screen


## Extensions
### 4a. Inputs Title
1. User clicks on title slot
2. User types in the event name 
3. Upon submitting, the system adds the data to the dashboard
### 5a. Inputs Contents
1. User clicks on contents slot
2. User types in the new event's contents
3. Upon submitting, the system adds the data to the dashboard
### 4c. Selects Back
1. User clicks on the Back button.
2. User is taken back to the log-in screen
3. No new event is added


### a. System crashes.
1. User closes application.
2. User reopens application and restarts the operations.
## Special Requirements
1. Android version 5.0 or more recent.
2. Touch screen.