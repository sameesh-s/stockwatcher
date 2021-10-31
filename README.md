
SWAGGER API DOCS : http://localhost:8080/v2/api-docs  
SWAGGER UI : http://localhost:8080/swagger-ui.html#/  


Use cases
---------
1. Create stocks with ticks init
2. Create wishlist with stocks init
3. query wishlist with selected strategy:
   https://localhost:8080/api/wishlist/{wishlistname}/strategy/{strategyname}
    So it will give the stocks which has the highest proximity for making a profit, in a sorted order
    Currently available strategies in the design are "putoption", "shortsell"
