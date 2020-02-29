# green screw

### green screw is a Spring Boot project
1. Spring Boot DevTools
1. Spring Data JPA
1. H2 Database or MySQL Driver 
1. Spring Web
1. Spring HATEOS



SQL tables

![picture](./images/db-diagram.svg)


```
curl http://127.0.0.1:8080/products
{
    "content": [
        {
            "productId": 1,
            "productCode": "O356XX9",
            "name": "Basil - Seedlings Cookstown",
            "quantity": 1,
            "price": 68.24,
            "likedSuppliers": [
                {
                    "supplierId": 2,
                    "name": "Aibox",
                    "phone": "4712356514"
                },
                {
                    "supplierId": 1,
                    "name": "Thoughtmix",
                    "phone": "6418597311"
                }
            ]
        },
        {
            "productId": 2,
            "productCode": "S56512A",
            "name": "Fuji Apples",
            "quantity": 200,
            "price": 14.32,
            "likedSuppliers": [
                {
                    "supplierId": 1,
                    "name": "Thoughtmix",
                    "phone": "6418597311"
                }
            ]
        },
        {
            "productId": 3,
            "productCode": "L923",
            "name": "Chips Potato Reg 43g",
            "quantity": 250,
            "price": 57.41,
            "likedSuppliers": [
                {
                    "supplierId": 1,
                    "name": "Thoughtmix",
                    "phone": "6418597311"
                }
            ]
        },
        {
            "productId": 4,
            "productCode": "D359",
            "name": "Pepper - Gypsy Pepper",
            "quantity": 111,
            "price": 81.21,
            "likedSuppliers": [
                {
                    "supplierId": 2,
                    "name": "Aibox",
                    "phone": "4712356514"
                }
            ]
        },
        {
            "productId": 5,
            "productCode": "O438",
            "name": "Lettuce - Treviso",
            "quantity": 17,
            "price": 27.49,
            "likedSuppliers": [
                {
                    "supplierId": 2,
                    "name": "Aibox",
                    "phone": "4712356514"
                }
            ]
        },
        {
            "productId": 6,
            "productCode": "S31815D",
            "name": "Tea - Decaf 1 Cup",
            "quantity": 60,
            "price": 41.9,
            "likedSuppliers": [
                {
                    "supplierId": 2,
                    "name": "Aibox",
                    "phone": "4712356514"
                }
            ]
        },
        {
            "productId": 7,
            "productCode": "M12141",
            "name": "Nut - Pecan, Halves",
            "quantity": 68,
            "price": 48.65,
            "likedSuppliers": []
        },
        {
            "productId": 8,
            "productCode": "G40401",
            "name": "Soup - Campbells, Creamy",
            "quantity": 8,
            "price": 78.11,
            "likedSuppliers": []
        },
        {
            "productId": 9,
            "productCode": "O36093",
            "name": "Spic And Span All Purpose",
            "quantity": 9,
            "price": 40.66,
            "likedSuppliers": []
        },
        {
            "productId": 10,
            "productCode": "S79122G",
            "name": "Beer - Tetleys",
            "quantity": 10,
            "price": 13.18,
            "likedSuppliers": [
                {
                    "supplierId": 20,
                    "name": "Eadel jr",
                    "phone": "9634904578"
                }
            ]
        },
        {
            "productId": 11,
            "productCode": "S90871",
            "name": "Cauliflower",
            "quantity": 11,
            "price": 38.83,
            "likedSuppliers": []
        },
        {
            "productId": 12,
            "productCode": "B4481",
            "name": "Quinoa",
            "quantity": 12,
            "price": 42.46,
            "likedSuppliers": []
        },
        {
            "productId": 13,
            "productCode": "S27391D",
            "name": "Beef - Prime Rib Aaa",
            "quantity": 13,
            "price": 79.52,
            "likedSuppliers": []
        },
        {
            "productId": 14,
            "productCode": "S838X1S",
            "name": "Nantucket Cranberry Juice",
            "quantity": 14,
            "price": 56.03,
            "likedSuppliers": []
        },
        {
            "productId": 15,
            "productCode": "S60819A",
            "name": "Wine - Vidal Icewine Magnotta",
            "quantity": 15,
            "price": 89.96,
            "likedSuppliers": []
        },
        {
            "productId": 16,
            "productCode": "S63321",
            "name": "Wine - Lamancha Do Crianza",
            "quantity": 16,
            "price": 93.21,
            "likedSuppliers": []
        },
        {
            "productId": 17,
            "productCode": "S91213",
            "name": "Appetizer - Mushroom Tart",
            "quantity": 17,
            "price": 2.06,
            "likedSuppliers": []
        },
        {
            "productId": 18,
            "productCode": "T5691XS",
            "name": "Potatoes - Purple, Organic",
            "quantity": 18,
            "price": 34.1,
            "likedSuppliers": []
        },
        {
            "productId": 19,
            "productCode": "V9300XS",
            "name": "Wine - Red, Lurton Merlot De",
            "quantity": 19,
            "price": 52.69,
            "likedSuppliers": []
        },
        {
            "productId": 20,
            "productCode": "S27312A",
            "name": "Chocolate Eclairs",
            "quantity": 20,
            "price": 21.55,
            "likedSuppliers": []
        },
        {
            "productId": 21,
            "productCode": "V345",
            "name": "Cake - Sheet Strawberry",
            "quantity": 21,
            "price": 96.45,
            "likedSuppliers": []
        },
        {
            "productId": 22,
            "productCode": "S0087",
            "name": "Salad Dressing",
            "quantity": 22,
            "price": 91.23,
            "likedSuppliers": []
        },
        {
            "productId": 23,
            "productCode": "S86919S",
            "name": "Pear - Packum",
            "quantity": 23,
            "price": 86.8,
            "likedSuppliers": []
        },
        {
            "productId": 24,
            "productCode": "M4848XG",
            "name": "Tomatoes - Plum, Canned",
            "quantity": 24,
            "price": 98.6,
            "likedSuppliers": []
        },
        {
            "productId": 25,
            "productCode": "M5032",
            "name": "Icecream - Dstk Super Cone",
            "quantity": 25,
            "price": 86.35,
            "likedSuppliers": []
        },
        {
            "productId": 26,
            "productCode": "Y37240S",
            "name": "Table Cloth 62x114 Colour",
            "quantity": 26,
            "price": 39.49,
            "likedSuppliers": []
        },
        {
            "productId": 27,
            "productCode": "H269",
            "name": "Scallops - Live In Shell",
            "quantity": 27,
            "price": 96.53,
            "likedSuppliers": []
        },
        {
            "productId": 28,
            "productCode": "E103493",
            "name": "Cheese - Le Cru Du Clocher",
            "quantity": 28,
            "price": 42.11,
            "likedSuppliers": []
        },
        {
            "productId": 29,
            "productCode": "H432",
            "name": "Ocean Spray - Kiwi Strawberry",
            "quantity": 29,
            "price": 46.45,
            "likedSuppliers": []
        },
        {
            "productId": 30,
            "productCode": "S61052S",
            "name": "Vector Energy Bar",
            "quantity": 30,
            "price": 4.91,
            "likedSuppliers": []
        },
        {
            "productId": 31,
            "productCode": "T22639D",
            "name": "Pork - Bacon, Sliced",
            "quantity": 31,
            "price": 44.71,
            "likedSuppliers": []
        },
        {
            "productId": 32,
            "productCode": "S99912",
            "name": "Oil - Canola",
            "quantity": 32,
            "price": 51.14,
            "likedSuppliers": []
        },
        {
            "productId": 33,
            "productCode": "S23160",
            "name": "Carbonated Water - Peach",
            "quantity": 33,
            "price": 85.32,
            "likedSuppliers": []
        },
        {
            "productId": 34,
            "productCode": "T84613S",
            "name": "Leeks - Baby, White",
            "quantity": 34,
            "price": 68.4,
            "likedSuppliers": []
        },
        {
            "productId": 35,
            "productCode": "S82191G",
            "name": "Sping Loaded Cup Dispenser",
            "quantity": 35,
            "price": 54.86,
            "likedSuppliers": []
        },
        {
            "productId": 36,
            "productCode": "S63298",
            "name": "Spring Roll Wrappers",
            "quantity": 36,
            "price": 59.07,
            "likedSuppliers": []
        },
        {
            "productId": 37,
            "productCode": "S52121B",
            "name": "Burger Veggie",
            "quantity": 37,
            "price": 11.31,
            "likedSuppliers": []
        },
        {
            "productId": 38,
            "productCode": "T444X1S",
            "name": "Pasta - Penne Primavera, Single",
            "quantity": 38,
            "price": 39.53,
            "likedSuppliers": []
        },
        {
            "productId": 39,
            "productCode": "T590X2D",
            "name": "Fish - Soup Base, Bouillon",
            "quantity": 39,
            "price": 53.63,
            "likedSuppliers": []
        },
        {
            "productId": 40,
            "productCode": "O2302",
            "name": "Mushroom - Porcini Frozen",
            "quantity": 40,
            "price": 25.67,
            "likedSuppliers": []
        },
        {
            "productId": 41,
            "productCode": "Y37001D",
            "name": "Pork Ham Prager",
            "quantity": 41,
            "price": 42.38,
            "likedSuppliers": []
        },
        {
            "productId": 42,
            "productCode": "R402353",
            "name": "Pepper - Red Bell",
            "quantity": 42,
            "price": 5.82,
            "likedSuppliers": []
        },
        {
            "productId": 43,
            "productCode": "O102",
            "name": "Beef - Ground Lean Fresh",
            "quantity": 43,
            "price": 96.71,
            "likedSuppliers": []
        },
        {
            "productId": 44,
            "productCode": "T22432S",
            "name": "Squash - Pattypan, Yellow",
            "quantity": 44,
            "price": 34.03,
            "likedSuppliers": []
        },
        {
            "productId": 45,
            "productCode": "A05",
            "name": "Cookie Dough - Chocolate Chip",
            "quantity": 45,
            "price": 79.62,
            "likedSuppliers": []
        },
        {
            "productId": 46,
            "productCode": "S01449",
            "name": "Cauliflower",
            "quantity": 46,
            "price": 94.65,
            "likedSuppliers": []
        },
        {
            "productId": 47,
            "productCode": "M7113",
            "name": "Egg - Salad Premix",
            "quantity": 47,
            "price": 94.31,
            "likedSuppliers": []
        },
        {
            "productId": 48,
            "productCode": "S72116N",
            "name": "Sour Puss - Tangerine",
            "quantity": 48,
            "price": 16.75,
            "likedSuppliers": []
        },
        {
            "productId": 49,
            "productCode": "O334XX2",
            "name": "Liqueur - Melon",
            "quantity": 49,
            "price": 39.07,
            "likedSuppliers": []
        },
        {
            "productId": 50,
            "productCode": "S09e12XD",
            "name": "Five Alive Citrus",
            "quantity": 50,
            "price": 34.79,
            "likedSuppliers": []
        }
    ],
    "pageable": {
        "sort": {
            "unsorted": false,
            "sorted": true,
            "empty": false
        },
        "pageNumber": 0,
        "pageSize": 50,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 20,
    "last": false,
    "totalElements": 1000,
    "first": true,
    "size": 50,
    "number": 0,
    "sort": {
        "unsorted": false,
        "sorted": true,
        "empty": false
    },
    "numberOfElements": 50,
    "empty": false
}
```
 with parametars
 ```
 curl http://localhost:8080/products/?size=3&page=3&sort=name,desc
 {
    "content": [
        {
            "productId": 934,
            "productCode": "R683",
            "name": "Yeast Dry - Fermipan",
            "quantity": 934,
            "price": 56.4,
            "likedSuppliers": []
        },
        {
            "productId": 217,
            "productCode": "V272XXD",
            "name": "Yeast Dry - Fermipan",
            "quantity": 217,
            "price": 90.5,
            "likedSuppliers": []
        },
        {
            "productId": 819,
            "productCode": "N393",
            "name": "Yeast Dry - Fermipan",
            "quantity": 819,
            "price": 36.71,
            "likedSuppliers": []
        }
    ],
    "pageable": {
        "sort": {
            "unsorted": false,
            "sorted": true,
            "empty": false
        },
        "pageNumber": 3,
        "pageSize": 3,
        "offset": 9,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 334,
    "last": false,
    "totalElements": 1000,
    "first": false,
    "size": 3,
    "number": 3,
    "sort": {
        "unsorted": false,
        "sorted": true,
        "empty": false
    },
    "numberOfElements": 3,
    "empty": false
}
 ```
 or one product at a time
 ```
 curl http://localhost:8080/products/1
 {
    "productId": 1,
    "productCode": "O356XX9",
    "name": "Basil - Seedlings Cookstown",
    "quantity": 1,
    "price": 68.24,
    "likedSuppliers": [
        {
            "supplierId": 2,
            "name": "Aibox",
            "phone": "4712356514"
        },
        {
            "supplierId": 1,
            "name": "Thoughtmix",
            "phone": "6418597311"
        }
    ],
    "_links": {
        "self": {
            "href": "http://localhost:8080/products/1"
        },
        "suppliers": {
            "href": "http://localhost:8080/products"
        }
    }
}
 ```
