
INSERT INTO PUBLIC.STORAGE (ID, NAME) VALUES(1, 'Центральный склад');
INSERT INTO PUBLIC.STORAGE (ID, NAME) VALUES(2, 'Симиренко');
INSERT INTO PUBLIC.STORAGE (ID, NAME) VALUES(3, 'Копыловская');
INSERT INTO PUBLIC.STORAGE (ID, NAME) VALUES(4, 'Уборевича');
INSERT INTO PUBLIC.STORAGE (ID, NAME) VALUES(5, 'Донецкая');

INSERT INTO PUBLIC.PROVIDER (ID, NAME) VALUES(1, 'Мегаполис');
INSERT INTO PUBLIC.PROVIDER (ID, NAME) VALUES(2, 'Свиточ');
INSERT INTO PUBLIC.PROVIDER (ID, NAME) VALUES(3, 'Олга-трейд');

INSERT INTO PUBLIC.PRODUCTGROUP (ID, NAME) VALUES(1, 'Кондитерские изделия');
INSERT INTO PUBLIC.PRODUCTGROUP (ID, NAME) VALUES(2, 'Мясные изделия');
INSERT INTO PUBLIC.PRODUCTGROUP (ID, NAME) VALUES(3, 'Табачные изделия');

INSERT INTO PUBLIC.PRODUCT (ID, MEASURE, NAME, GROUP_ID, BARCODE) VALUES(1, 1, 'Шоколад Корона 250г', 1, '4821006150134');
INSERT INTO PUBLIC.PRODUCT (ID, MEASURE, NAME, GROUP_ID, BARCODE) VALUES(2, 1, 'Шоколад Рошен 100г', 1, '4820164350014');
INSERT INTO PUBLIC.PRODUCT (ID, MEASURE, NAME, GROUP_ID, BARCODE) VALUES(3, 0, 'Ошеек свинной', 2, '122954');
INSERT INTO PUBLIC.PRODUCT (ID, MEASURE, NAME, GROUP_ID, BARCODE) VALUES(4, 1, 'Сигареты Marlboro', 3, '01456856');

INSERT INTO PUBLIC.PACKINGITEM (ID, PRICE, QUANTITY, SUM, PRODUCT_ID) VALUES (1, 25.50, 10, 255.00, 1);
INSERT INTO PUBLIC.PACKINGITEM (ID, PRICE, QUANTITY, SUM, PRODUCT_ID) VALUES (2, 10.50, 5, 52.50, 2);
INSERT INTO PUBLIC.PACKINGITEM (ID, PRICE, QUANTITY, SUM, PRODUCT_ID) VALUES (3, 80.00, 0.88, 70.40, 3);
INSERT INTO PUBLIC.PACKINGITEM (ID, PRICE, QUANTITY, SUM, PRODUCT_ID) VALUES (4, 25.00, 10, 250.00, 4);
INSERT INTO PUBLIC.PACKINGITEM (ID, PRICE, QUANTITY, SUM, PRODUCT_ID) VALUES (5, 25.50, 10, 255.00, 4);
