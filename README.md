# Bakery
## Order product packs getting always the minimal quantity of packs.

## Architecture
- Java
- Spring Boot
- Maven
- Tomcat
- JUnit
- Mockito
- H2 database
- Lombok

## Run tests

- mvn test

## Build

- mvn clean package

## Endpoints

Web port: 8090

Expose two endpoints.

- Endpoint with text body:<br/>

POST /order/order HTTP/1.1<br/>
Host: localhost:8090<br/>
10 VS5<br/>
14 MB11<br/>
13 CF<br/>

Response: <br/>
10 VS5 $8,99<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2 x $8,99<br/>
14 MB11 $34,90<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 x $24,95<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3 x $9,95<br/>
13 CF $15,90<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2 x $9,95<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1 x $5,95<br/>

- Endpoint with JSON objects of request and response:<br/>

POST /order/order-json HTTP/1.1<br/>
Host: localhost:8090<br/>
Content-Type: application/json<br/>
[<br/>
&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": "10",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productCode": "VS5"<br/>
&nbsp;&nbsp;},<br/>
&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": "14",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productCode": "MB11"<br/>
&nbsp;&nbsp;},<br/>
&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": "13",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productCode": CF"<br/>
&nbsp;&nbsp;}<br/>
]<br/>

Response:<br/>
[<br/>
&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": 10,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productCode": "VS5",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productTotalCost": 8.99,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"packs": [<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"packQuantity": 2,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": 5,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"packCost": 8.99<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br/>
&nbsp;&nbsp;&nbsp;&nbsp;]<br/>
&nbsp;&nbsp;},<br/>
&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": 14,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productCode": "MB11",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productTotalCost": 34.9,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"packs": [<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"packQuantity": 1,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": 8,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"packCost": 24.95<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"packQuantity": 3,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": 2,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"packCost": 9.95<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br/>
&nbsp;&nbsp;&nbsp;&nbsp;]<br/>
&nbsp;&nbsp;},<br/>
&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": 13,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productCode": "CF",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"productTotalCost": 15.899999999999999,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"packs": [<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"packQuantity": 2,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": 5,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"packCost": 9.95<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"packQuantity": 1,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"productQuantity": 3,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"packCost": 5.95<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br/>
&nbsp;&nbsp;&nbsp;&nbsp;]<br/>
&nbsp;&nbsp;}<br/>
]
