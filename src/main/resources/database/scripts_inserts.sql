INSERT INTO public.category(id, name) VALUES
  (1, 'Informatica'),(2, 'Escritorio'),
  (3, 'Cama mesa e banho'), (4,'Electronicos'),
  (5, 'Jardineria'), (6, 'Decoracion'), (7, 'Perfumeria');


INSERT INTO public.product (id, name, price) VALUES
  (1, 'Computadora', 2000.00),
  (2, 'Impresora', 800.00),
  (3, 'Mouse', 80.00),
  (4, 'Mesa de Escritorio',300.00),
  (5, 'Toalla', 50.00),
  (6, 'Colcha', 200.00),
  (7, 'TV true color', 1200.00),
  (8, 'Siega', 800.00),
  (9, 'Pantalla', 100.00),
  (10, 'Pendiente', 180.00),
  (11, 'Shampoo', 90.00);


INSERT INTO public.product_category(category_id, product_id) VALUES
  (1, 1), (1,2), (1,3),
  (2,2), (2,4),
  (3,5), (3,6),
  (4,1), (4,2), (4,3),(4,7),
  (5,8),
  (6,9), (6,10),
  (7,11);


INSERT INTO public.estate(id, name) VALUES (1,'Minas Gerais'), (2, 'Sao Paulo');
INSERT INTO public.city(id, name, state_id) VALUES (1, 'Uberlandia', 1), (2, 'Sao Paulo', 2), (3, 'Campinas', 2);


INSERT INTO client(id, cpf_ou_cnpj, email, name, type, password) VALUES (1, '36378912377', 'unacuentamas16@gmail.com','Maria Silva',1,'$2a$10$O5T2z3HTnMy52xoEMIjOcOs.E32A/tGXLSCLatHyeaHFbJY2lXZ6K');
INSERT INTO client(id, cpf_ou_cnpj, email, name, type, password) VALUES (2, '36378912327', 'admin@gmail.com','admin',1,'$2a$10$O5T2z3HTnMy52xoEMIjOcOs.E32A/tGXLSCLatHyeaHFbJY2lXZ6K');
INSERT INTO phone (client_entity_id, phone) VALUES (1,'93838393'),(1,'27363323');
INSERT INTO profile(client_entity_id, profile) VALUES (1,2);
INSERT INTO profile(client_entity_id, profile) VALUES (1,3);
INSERT INTO profile(client_entity_id, profile) VALUES (2,1);
INSERT INTO profile(client_entity_id, profile) VALUES (2,3);


INSERT INTO direction (id, cep,complement, district, number, street, city_id, client_id) VALUES (1, '38220834', 'Apto 203', 'Jardim', 300, 'Rua Flores', 1, 1);
INSERT INTO direction (id, cep,complement, district, number, street, city_id, client_id) VALUES (2, '38222834', 'Apto 204', 'Jardim', 300, 'Rua nose', 1, 2);


INSERT INTO public.requisition (id, address_id, moment, client_id) VALUES (1, 1, DATE '2017/09/30', 1);
INSERT INTO public.requisition (id, address_id, moment, client_id) VALUES (2, 1, DATE '2017/10/10', 1);


INSERT INTO public.payment(order_id, address_id, pay_state) VALUES (1,1,2);
INSERT INTO public.card_payment(plots_number, order_id) VALUES (6, 1);


INSERT INTO public.payment(order_id, address_id, pay_state) VALUES (2,1,1);
INSERT INTO public.ticket_payment(expiration_data, pay_data, order_id) VALUES (DATE '2017/10/20', null, 2);


INSERT INTO public.order_item(discount, price, quantity, product_id, order_id) VALUES (0.00, 2000.00, 1, 1, 1);


INSERT INTO public.order_item(discount, price, quantity, product_id, order_id) VALUES (0.00, 80.00, 2, 3, 1);


INSERT INTO public.order_item(discount, price, quantity, product_id, order_id) VALUES (100.00, 800.00, 1, 2, 2);
