INSERT INTO `a2`.`parts291`
(`partNo291`,`qoh291`,`partName291`,`partPrice291`)
VALUES
(1,25,"Bolt A38",0.38),
(2,35,"Bolt A34",0.28),
(3,35,"Nail C8x20",2.15),
(4,10,"Nail C8x100",10.00);

INSERT INTO `a2`.`clients291`
(`clientId291`,`clientCity291`,`clientName291`,`clientPassword291`,`moneyOwed291`)
VALUES
(1,"Halifax","John Doe","pa55word",0),
(2,"Halifax","Frank Smith","bluejays78",0);

INSERT INTO `a2`.`pos291`
(`poNo291`,`dateOfPO291`,`status291`,`clientCompID291`)
VALUES
(1,'2018-05-30',"fulfilled",1),
(2,'2019-05-30',"fulfilled",1),
(3,'2022-05-20',"Received",2);

INSERT INTO `a2`.`lines291`
(`qty291`,`priceOrdered291`,`partNo291`,`poNo291`,`lineNo291`)
VALUES
(10,0.34,2,1,1),
(5,0.40,1,1,2),
(2,11.10,4,2,1);
