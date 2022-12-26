INSERT INTO users (id, name, role) VALUES (1, 'Someone', 'normal');
INSERT INTO users (id, name, role) VALUES (2, 'Anyone', 'normal');
INSERT INTO users (id, name, role) VALUES (3, 'The CEO', 'owner');

INSERT INTO cart (id, owner_id) VALUES (1, 1);
INSERT INTO cart (id, owner_id) VALUES (2, 2);
INSERT INTO cart (id, owner_id) VALUES (3, 3);

INSERT INTO cart_item (id, cart_id, quantity, unit_price) VALUES (1, 1, 2, 9.99);
INSERT INTO cart_item (id, cart_id, quantity, unit_price) VALUES (2, 1, 1, 9.99);
INSERT INTO cart_item (id, cart_id, quantity, unit_price) VALUES (3, 1, 1, 9.99);
INSERT INTO cart_item (id, cart_id, quantity, unit_price) VALUES (4, 2, 3, 9.99);
INSERT INTO cart_item (id, cart_id, quantity, unit_price) VALUES (5, 2, 1, 9.99);
INSERT INTO cart_item (id, cart_id, quantity, unit_price) VALUES (6, 3, 7, 9.99);

INSERT INTO cart_campaign (id, cart_id, campaign_name, absolute_value) VALUES (1, 1, 'BlackFriday', 15.00);
INSERT INTO cart_campaign (id, cart_id, campaign_name, absolute_value) VALUES (2, 2, 'Birthday', 10.00);
INSERT INTO cart_campaign (id, cart_id, campaign_name, absolute_value) VALUES (3, 3, 'Birthday', 10.00);

INSERT INTO coupon (id, coupon_code, percentual_discount) VALUES (1, 'DESPAT', 5.00);
INSERT INTO coupon (id, coupon_code, percentual_discount) VALUES (2, 'JAVA17', 3.00);