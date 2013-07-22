-- Create permissions

call createPermission('PERM_CREATE_ACCOUNTS');
call createPermission('PERM_READ_ACCOUNTS');
call createPermission('PERM_UPDATE_ACCOUNTS');
call createPermission('PERM_DELETE_ACCOUNTS');
call createPermission('PERM_ADMIN_ACCOUNTS');
call createPermission('PERM_CREATE_FORUMS');
call createPermission('PERM_READ_FORUMS');
call createPermission('PERM_UPDATE_FORUMS');
call createPermission('PERM_DELETE_FORUMS');
call createPermission('PERM_ADMIN_FORUMS');
call createPermission('PERM_CREATE_MESSAGES');
call createPermission('PERM_READ_MESSAGES');
call createPermission('PERM_UPDATE_MESSAGES');
call createPermission('PERM_DELETE_MESSAGES');
call createPermission('PERM_ADMIN_MESSAGES');



-- Create roles

call createRole('ROLE_USER', @role_user);
call roleHasPermission(@role_user, 'PERM_READ_ACCOUNTS');
call roleHasPermission(@role_user, 'PERM_READ_FORUMS');
call roleHasPermission(@role_user, 'PERM_CREATE_MESSAGES');
call roleHasPermission(@role_user, 'PERM_READ_MESSAGES');

call createRole('ROLE_ADMIN', @role_admin);
call roleHasPermission(@role_admin, 'PERM_UPDATE_MESSAGES');
call roleHasPermission(@role_admin, 'PERM_DELETE_MESSAGES');
call roleHasPermission(@role_admin, 'PERM_ADMIN_MESSAGES');

call createRole('ROLE_STUDENT', @role_student);
call createRole('ROLE_FACULTY', @role_faculty);


-- Create accounts

call createAccount('paula', 'Paula', 'Cazares', 'paula@example.com', @paula);
call accountHasRole(@paula, @role_user);

call createAccount('daniel', 'Daniel', 'Cazares', 'daniel@example.com', @daniel);
call accountHasRole(@daniel, @role_user);
call accountHasRole(@daniel, @role_student);

call createAccount('julia', 'Julia', 'Cazares', 'julia@example.com', @julia);
call accountHasRole(@julia, @role_user);
call accountHasRole(@julia, @role_faculty);

call createAccount('elvira', 'Elvira', 'Cazares', 'elvira@example.com', @elvira);
call accountHasRole(@elvira, @role_user);
call accountHasRole(@elvira, @role_student);
call accountHasRole(@elvira, @role_faculty);

call createAccount('juan', 'Juan', 'Cazares', 'juan@example.com', @juan);
call accountHasRole(@juan, @role_user);
call accountHasRole(@juan, @role_admin);


-- Create site, forums and messages

call createAclClass('java.lang.Object', @site_class);
call createAclClass('com.springinpractice.ch07.domain.Forum', @forum_class);
call createAclClass('com.springinpractice.ch07.domain.Message', @message_class);

call createSite(@site_oid);

call createForum('Algebra I', @julia, @forum);
call createMessage(@forum, @julia, '2012-09-28 12:34:03', 'What *is* a variable?');
call createMessage(@forum, @juan, '2012-09-30 12:34:19', 'This class is too hard');
call createMessage(@forum, @julia, '2012-10-01 14:05:21', 'Curses, Descartes');

call createForum('Algebra II/Trigonometry', @julia, @forum);
call createMessage(@forum, @elvira, '2012-09-29 04:01:39', 'now i know how tall that pyramid is');
call createMessage(@forum, @paula, '2012-09-30 16:04:11', 'When will I ever use this??');
call createMessage(@forum, @elvira, '2012-09-30 14:30:21', 'buy v1@gRA 0nL1n3!');
update message set visible = 0 where id = last_insert_id();
call createMessage(@forum, @daniel, '2012-10-01 19:37:00', 'Solving system of linear equations');
call createMessage(@forum, @daniel, '2012-10-01 21:58:42', 'Need help applying Gaussian elimination');

call createForum('Precalculus', @julia, @forum);
call createMessage(@forum, @julia, '2012-09-27 16:32:09', 'formula for computing the volume of a sphere');
call createMessage(@forum, @juan, '2012-10-01 17:48:02', 'Isn''t a 96-gon basically the same as a circle');
call createMessage(@forum, @julia, '2012-10-01 17:53:36', 'Join my precalc Facebook group');

call createForum('Calculus I', @elvira, @forum);

call createForum('Calculus II', @elvira, @forum);
call createMessage(@forum, @elvira, '2012-09-27 12:34:56', 'Relationship between differentiation and integration');
call createMessage(@forum, @daniel, '2012-09-30 12:43:45', 'Integrating a volume');
call createMessage(@forum, @paula, '2012-10-01 08:23:02', 'epsilon-delta definition of a limit');
call createMessage(@forum, @julia, '2012-10-01 09:56:39', 'Newton or Leibniz');
call createMessage(@forum, @julia, '2012-10-01 11:02:01', 'Help!!! Too many integration rules');

call createForum('Model theory of second-order intuitionistic modal logics', @elvira, @forum);
call createMessage(@forum, @elvira, '2012-09-23 14:29:06', 'Possible worlds semantics');
call createMessage(@forum, @daniel, '2012-09-28 14:31:22', 'Kripke on naming and necessity');
call createMessage(@forum, @julia, '2012-09-30 16:17:16', 'Nonconstructive proof that P != NP. Is it good enough??');
call createMessage(@forum, @paula, '2012-09-30 19:43:53', 'Who is Archimedes Plutonium?');






   
insert into registration values
    (1, 'juan', 'Juan', 'Juan', 'Cazares', 'juan.cazares@example.com', 'Seattle', '7777777777', 'contactName', 'travelArranger', 'Milliman', 'ada', 'Golf', '1', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'vegan', 'No Peanuts', 'King', null, '2013/07/07', '2013/07/07', '2013/07/07', '2013/07/07', null, null, 'Alaska #777', 'Alaska #7777', null, null, null, null, null),
    (2, 'elvira', 'Elvira', 'Elvira', 'Cazares', 'elvira.cazares@example.com', 'San Diego', '7777777777', 'contactName', 'travelArranger', 'Milliman', 'ada', 'On My Own', '1','1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'vegetarian', 'No Peanuts', 'No Smoking', null, '2013/07/07', '2013/07/07', '2013/07/07', '2013/07/07', null, null, 'Alaska #777', 'Alaska #7777', null, null, null, null, null),
    (3, 'julia', 'Julia', 'Julia', 'Cazares', 'julia.cazares@example.com', 'NY', '7777777777', 'contactName', 'travelArranger', 'Milliman', 'ada', 'Mountain Climbing', '1', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'Low Carb', 'No Peanuts', 'King', null, '2013/07/07', '2013/07/07', '2013/07/07', '2013/07/07',  null, null, 'Alaska #777', 'Alaska #7777', null, null, null, null, null);


  insert into event values
    (1, 'Juan Cazares', 'juan.cazares@example.com', '1a - This is breakout choice 1', 'Session Description 1', 'breakout', '1',  null, null),
    (2, 'Elvira Cazares', 'elvira.cazares@example.com', '1b - This is breakout choice 1', 'Session Description 2', 'breakout', '1',  null, null),
    (3, 'Julia Cazares', 'julia.cazares@example.com', '1c - This is breakout choice 1', 'Session Description 3', 'breakout', '1',  null, null),
    (4, 'Julia Cazares', 'julia2.cazares@example.com', '1d - This is breakout choice 1', 'Session Description 4', 'breakout', '1',  null, null),
    (5, 'Julia Cazares', 'julia3.cazares@example.com', '1e - This is breakout choice 1', 'Session Description 5', 'breakout', '1',  null, null),
    (6, 'Juan Cazares', 'juan1.cazares@example.com', '2a - This is breakout choice 2', 'Session Description 1', 'breakout', '2',  null, null),
    (7, 'Elvira Cazares', 'elvira2.cazares@example.com', '2b - This is breakout choice 2', 'Session Description 2', 'breakout', '2',  null, null),
    (8, 'Julia Cazares', 'julia3.cazares@example.com', '2c - This is breakout choice 2', 'Session Description 3', 'breakout', '2',  null, null),
    (9, 'Julia Cazares', 'julia31.cazares@example.com', '3a - This is breakout choice 3', 'Session Description 3', 'breakout', '3',  null, null),
    (10, 'Julia Cazares', 'julia32.cazares@example.com', '3b - This is breakout choice 3', 'Session Description 3', 'breakout', '3',  null, null),
    (11, 'Julia Cazares', 'julia33.cazares@example.com', '3c - This is breakout choice 3', 'Session Description 3', 'breakout', '3',  null, null),
    (12, 'Julia Cazares', 'julia34.cazares@example.com', '3d - This is breakout choice 3', 'Session Description 3', 'breakout', '3',  null, null),
    (13, 'Julia Cazares', 'julia35.cazares@example.com', '4a - This is breakout choice 4', 'Session Description 3', 'breakout', '4',  null, null),
    (14, 'Julia Cazares', 'julia3777.cazares@example.com', '4b - This is breakout choice 4', 'Session Description 3', 'breakout', '4',  null, null),
    (15, 'Julia Cazares', 'julia371.cazares@example.com', '5a - This is breakout choice 3', 'Session Description 3', 'breakout', '5',  null, null),
    (16, 'Julia Cazares', 'julia372.cazares@example.com', '5b - This is breakout choice 3', 'Session Description 3', 'breakout', '5',  null, null),
    (17, 'Julia Cazares', 'julia373.cazares@example.com', '5c - This is breakout choice 3', 'Session Description 3', 'breakout', '5',  null, null),
    (18, 'Julia Cazares', 'julia374.cazares@example.com', '5d - This is breakout choice 3', 'Session Description 3', 'breakout', '5',  null, null),
    (19, 'Julia Cazares', 'julia35.cazares@example.com', '5e - This is breakout choice 4', 'Session Description 3', 'breakout', '5',  null, null),
    (20, 'Julia Cazares', 'julia37777.cazares@example.com', '5f - This is breakout choice 4', 'Session Description 3', 'breakout', '5',  null, null),

    (21, 'Julia Cazares', 'julia35.7cazares@example.com', '8g - This is breakout choice 4', 'Session Description 3', 'breakout', '8',  null, null),
    (22, 'Julia Cazares', 'julia37777.7cazares@example.com', '9h - This is breakout choice 4', 'Session Description 3', 'breakout', '9',  null, null),
    (23, 'Julia Cazares', 'julia77.7cazares@example.com', '10a - This is breakout choice 77', 'Session Description 10', 'breakout', '10',  null, null),
    (24, 'Julia Cazares', 'julia37777.7cazares@example.com', '10a - This is breakout choice 777', 'Session Description 10', 'breakout', '10',  null, null),
    (25, 'Julia Cazares', 'julia732.777cazares@example.com', '6a - This is breakout choice 3', 'Session Description 3', 'breakout', '6',  null, null),
    (26, 'Julia Cazares', 'julia32.7cazares@example.com', '6b - This is breakout choice 3', 'Session Description 3', 'breakout', '6',  null, null),
    (27, 'Julia Cazares', 'julia33.7cazares@example.com', '6c - This is breakout choice 3', 'Session Description 3', 'breakout', '6',  null, null),
    (28, 'Julia Cazares', 'julia34.7cazares@example.com', '6d - This is breakout choice 3', 'Session Description 3', 'breakout', '6',  null, null),
    (29, 'Julia Cazares', 'julia35.7cazares@example.com', '7a - This is breakout choice 4', 'Session Description 3', 'breakout', '7',  null, null),
    (30, 'Julia Cazares', 'julia3777.7cazares@example.com', '7b - This is breakout choice 4', 'Session Description 3', 'breakout', '7',  null, null),
    (31, 'Julia Cazares', 'julia371.7cazares@example.com', '7c - This is breakout choice 3', 'Session Description 3', 'breakout', '7',  null, null),
    (32, 'Julia Cazares', 'julia372.7cazares@example.com', '7d - This is breakout choice 3', 'Session Description 3', 'breakout', '7',  null, null),
    (33, 'Julia Cazares', 'julia373.7cazares@example.com', '7e - This is breakout choice 3', 'Session Description 3', 'breakout', '7',  null, null),
    (34, 'Julia Cazares', 'julia374.7cazares@example.com', '7f - This is breakout choice 3', 'Session Description 3', 'breakout', '7',  null, null),
    (35, 'Julia Cazares', 'julia35.7cazares@example.com', '7g - This is breakout choice 4', 'Session Description 3', 'breakout', '7',  null, null),
    (37, 'Julia Cazares', 'julia37777.7cazares@example.com', '7h - This is breakout choice 4', 'Session Description 3', 'breakout', '7',  null, null),
	
    
    
    (38, 'null', 'ducky.1928@cazares@gmail.com', 'Golf', 'Golf Description 3', 'Activity', 'null',  null, null),
	(39, 'null', 'ducky.1928@cazares@gmail.com', 'Swimming', 'Golf Description 3', 'Activity', 'null',  null, null),
    (40, 'null', 'ducky.1928@cazares@gmail.com', 'Mountain Climbing', 'Golf Description 3', 'Activity', 'null',  null, null);
    
    
  


