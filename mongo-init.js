conn = new Mongo();
db = conn.getDB("admin");

db.product.insert({ "name": "Wood" });
db.product.insert({ "name": "Window" });