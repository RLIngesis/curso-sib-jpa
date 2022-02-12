drop table sucursal_vendedor;
drop table sucursal;
drop table vendedor;
drop table cliente;


create table cliente (
    id_cliente number,
    nombre varchar,
    direccion varchar,
    nit varchar,
    telefono varchar,
    email varchar,
    primary key (id_cliente)
);

create table sucursal (
    id_sucursal number,
    nombre varchar,
    direccion varchar,
    primary key (id_sucursal)
);

create table vendedor (
    id_vendedor number,
    nombre varchar,
    puesto varchar,
    primary key (id_vendedor)
);

create table sucursal_vendedor (
    id_sucursal number,
    id_vendedor number,
    primary key (id_sucursal, id_vendedor),
    foreign key (id_sucursal) references sucursal(id_sucursal),
    foreign key (id_vendedor) references vendedor(id_vendor)
);

insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (1, 'Yvette Brabender', '3509 Everett Drive', '0811614271', '(961) 8675969', 'ybrabender0@twitpic.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (2, 'Dorian Doby', '8 Pond Terrace', '6797333024', '(539) 1686115', 'ddoby1@bizjournals.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (3, 'Shoshanna Catanheira', '49 Messerschmidt Avenue', '7199708793', '(812) 6630733', 'scatanheira2@amazon.co.uk');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (4, 'Shirlee Van den Hof', '8745 Fuller Circle', '4732373704', '(872) 1464687', 'svan3@guardian.co.uk');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (5, 'Gerrilee Daltry', '7874 Norway Maple Hill', '2137483963', '(285) 8947434', 'gdaltry4@acquirethisname.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (6, 'Beverley Waterstone', '4324 Heffernan Alley', '3871999733', '(277) 4925025', 'bwaterstone5@theglobeandmail.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (7, 'Brew Trytsman', '13868 Barnett Drive', '6223397836', '(238) 9685952', 'btrytsman6@arizona.edu');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (8, 'Wallace Radclyffe', '3 Cambridge Hill', '7488164911', '(930) 9614584', 'wradclyffe7@so-net.ne.jp');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (9, 'Fabien Seacombe', '17 Delladonna Way', '3004764911', '(476) 8209875', 'fseacombe8@unesco.org');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (10, 'Rudy Coppo', '0 Sutteridge Drive', '5622059321', '(145) 5485164', 'rcoppo9@ihg.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (11, 'Blinnie Gallemore', '20575 Everett Avenue', '7517532693', '(805) 5104261', 'bgallemorea@cdbaby.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (12, 'Karalee Sandham', '12 Cottonwood Avenue', '0039247627', '(317) 3713606', 'ksandhamb@nba.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (13, 'Martie Ferras', '0 Quincy Road', '6760112105', '(827) 9774630', 'mferrasc@epa.gov');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (14, 'Vanya Ravens', '99 Lakewood Gardens Trail', '6308810002', '(774) 6097552', 'vravensd@scientificamerican.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (15, 'Dolly Eastridge', '79 Mifflin Circle', '7883582860', '(882) 2660815', 'deastridgee@samsung.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (16, 'Dev Tetsall', '0 Schlimgen Way', '3049419822', '(110) 7115512', 'dtetsallf@surveymonkey.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (17, 'Horst McCrossan', '04 Sauthoff Plaza', '9068033557', '(113) 4634038', 'hmccrossang@wunderground.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (18, 'Massimiliano Nockles', '6 Arrowood Pass', '2749152674', '(452) 1097332', 'mnocklesh@printfriendly.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (19, 'Yanaton Calliss', '26 Manley Terrace', '5213828043', '(355) 7104950', 'ycallissi@topsy.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (20, 'Standford Gozney', '8356 Heffernan Center', '7640008417', '(667) 1616120', 'sgozneyj@psu.edu');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (21, 'Ashla Eagleton', '69 Corben Street', '4934960198', '(889) 6694269', 'aeagletonk@alexa.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (22, 'Frederic Dyhouse', '7648 Mandrake Terrace', '4658030829', '(280) 5922083', 'fdyhousel@ustream.tv');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (23, 'Wanids Le Noir', '538 School Way', '8851297452', '(698) 8215259', 'wlem@latimes.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (24, 'Shirline Gianettini', '495 Spohn Crossing', '0369737253', '(713) 1536762', 'sgianettinin@sciencedaily.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (25, 'Ami Bolgar', '73 Dennis Alley', '6553000654', '(146) 7812950', 'abolgaro@wufoo.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (26, 'Denys Ilchenko', '21 Randy Alley', '3019938791', '(229) 3333832', 'dilchenkop@illinois.edu');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (27, 'Veronike Scare', '5602 Thompson Drive', '8783609245', '(565) 8079340', 'vscareq@spiegel.de');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (28, 'Atlanta Tingly', '88 Northport Lane', '8022713600', '(464) 7667330', 'atinglyr@theatlantic.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (29, 'Trista Bezant', '4023 Summit Avenue', '8888276718', '(319) 5893726', 'tbezants@senate.gov');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (30, 'Elyn Cleworth', '12059 Pond Terrace', '6333253405', '(267) 6598150', 'eclewortht@scientificamerican.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (31, 'Munmro Farndell', '51 Lakewood Crossing', '7021323735', '(713) 1575249', 'mfarndellu@google.fr');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (32, 'Katee Sambath', '62 Hintze Junction', '0062391534', '(759) 2292062', 'ksambathv@hubpages.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (33, 'Remington Greenhead', '32 Artisan Way', '5871523315', '(553) 3551759', 'rgreenheadw@prlog.org');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (34, 'Brandea Busain', '83 Cambridge Road', '2615512676', '(664) 9895681', 'bbusainx@state.tx.us');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (35, 'Sully McGrowther', '3 Rockefeller Junction', '2103368320', '(178) 1866733', 'smcgrowthery@canalblog.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (36, 'Darcy Cullity', '54979 Lakewood Road', '6354681260', '(540) 3079333', 'dcullityz@noaa.gov');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (37, 'Clementine Chevis', '3235 Loeprich Alley', '2931430633', '(426) 8025078', 'cchevis10@bloglovin.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (38, 'Ana Toffoletto', '924 Memorial Court', '3306068632', '(587) 7786188', 'atoffoletto11@wiley.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (39, 'Barbara-anne Prodrick', '41 Pierstorff Junction', '7323807611', '(977) 6980319', 'bprodrick12@hatena.ne.jp');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (40, 'Raimondo Dessaur', '03 Glacier Hill Place', '4984764007', '(178) 6702877', 'rdessaur13@cdbaby.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (41, 'Layla Curtis', '5 Commercial Alley', '7776592641', '(871) 2558075', 'lcurtis14@addtoany.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (42, 'Bartholomeus Ert', '2 Commercial Terrace', '8116839853', '(265) 2519790', 'bert15@bizjournals.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (43, 'Benson Balleine', '9 Northport Circle', '6358828916', '(234) 3528601', 'bballeine16@naver.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (44, 'Shanan Richardon', '77 Almo Center', '9690179683', '(384) 4193480', 'srichardon17@guardian.co.uk');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (45, 'Adrianna Glason', '2 Randy Point', '3856937285', '(994) 7286176', 'aglason18@last.fm');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (46, 'Roseanna Katz', '0600 Crowley Place', '5938138507', '(398) 1574338', 'rkatz19@jimdo.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (47, 'Kerrie Lea', '101 Pleasure Road', '3069392407', '(991) 7854451', 'klea1a@wired.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (48, 'Bonnee Chamberlayne', '86634 Aberg Center', '6340517811', '(413) 4312338', 'bchamberlayne1b@indiegogo.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (49, 'Stefania Pengelley', '5 Manley Road', '9189670000', '(869) 5064279', 'spengelley1c@yellowpages.com');
insert into cliente (id_cliente, nombre, direccion, nit, telefono, email) values (50, 'Fayre Hobgen', '4 Eliot Hill', '0006907784', '(404) 8141045', 'fhobgen1d@vinaora.com');

insert into sucursal (id_sucursal, nombre, direccion) values (1, 'Sucursal 1', '30938 Shasta Junction');
insert into sucursal (id_sucursal, nombre, direccion) values (2, 'Sucursal 2', '920 Dakota Plaza');
insert into sucursal (id_sucursal, nombre, direccion) values (3, 'Sucursal 3', '2 Oriole Avenue');
insert into sucursal (id_sucursal, nombre, direccion) values (4, 'Sucursal 4', '73328 Marcy Hill');
insert into sucursal (id_sucursal, nombre, direccion) values (5, 'Sucursal 5', '344 Mayfield Street');

insert into vendedor (id_vendedor, nombre, puesto) values (1, 'Bonita Beaconsall', 'Food Chemist');
insert into vendedor (id_vendedor, nombre, puesto) values (2, 'Cal Magenny', 'Systems Administrator III');
insert into vendedor (id_vendedor, nombre, puesto) values (3, 'Zachariah Phinnis', 'Account Coordinator');
insert into vendedor (id_vendedor, nombre, puesto) values (4, 'Ave Sautter', 'Teacher');
insert into vendedor (id_vendedor, nombre, puesto) values (5, 'Alexio Chandlar', 'Chemical Engineer');
insert into vendedor (id_vendedor, nombre, puesto) values (6, 'Ira Andrivel', 'Environmental Tech');
insert into vendedor (id_vendedor, nombre, puesto) values (7, 'Elsey Mc Faul', 'Senior Financial Analyst');
insert into vendedor (id_vendedor, nombre, puesto) values (8, 'Lek Stothert', 'Statistician I');
insert into vendedor (id_vendedor, nombre, puesto) values (9, 'Davine Elder', 'Associate Professor');
insert into vendedor (id_vendedor, nombre, puesto) values (10, 'Eula Oneile', 'Database Administrator IV');
insert into vendedor (id_vendedor, nombre, puesto) values (11, 'Matteo Pisco', 'Account Executive');
insert into vendedor (id_vendedor, nombre, puesto) values (12, 'Brandon Fincham', 'Senior Developer');
insert into vendedor (id_vendedor, nombre, puesto) values (13, 'Andre Gershom', 'Help Desk Technician');
insert into vendedor (id_vendedor, nombre, puesto) values (14, 'Nadeen Hodgen', 'Web Developer I');
insert into vendedor (id_vendedor, nombre, puesto) values (15, 'Anne Bosma', 'Media Manager I');

insert into sucursal_vendedor (id_sucursal, id_vendedor) values (1,1);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (1,2);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (1,3);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (2,4);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (2,5);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (2,6);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (3,7);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (3,8);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (3,9);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (4,10);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (4,11);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (4,12);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (5,13);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (5,14);
insert into sucursal_vendedor (id_sucursal, id_vendedor) values (5,15);
