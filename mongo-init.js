conn = new Mongo();
db = conn.getDB("admin");

db.product.insert({"id":"61aed1d738dc25373b8ce4f4","name":"Cup","locationCode":"A","productDetails":[{"quantity":10,"subCode":"WOOD2"}]});