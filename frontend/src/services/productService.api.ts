import axios from "axios";
export async function getProduct() {
  try {
    const data = await axios.get("http://localhost:8080/products");
    return data;
  } catch (error) {
    console.log(error);
  }
}
export async function createProduct(name: any, price: any, description: any) {
  try {
    const data = await axios.post("http://localhost:8080/products", {
      name: name,
      price: price,
      description: description,
    });
    window.location.href = "/product";
  } catch (error) {
    console.log(error);
  }
}

export async function deleteProduct(id: string) {
  try {
    const data = await axios.delete("http://localhost:8080/products/" + id);
    window.location.href = "/product";
  } catch (error) {
    console.log(error);
  }
}
export async function updateProduct(
  id: any,
  name: any,
  price: any,
  description: any
) {
  console.log(id);
  console.log(name);
  console.log(price);
  console.log(description);
  try {
    const data = await axios.put("http://localhost:8080/products", {
      id: id,
      name: name,
      price: price,
      description: description,
    });
    window.location.href = "/product";
  } catch (error) {
    console.log(error);
  }
}
