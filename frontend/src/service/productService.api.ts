import axios from "axios";
export async function getProduct() {
  try {
    const data = await axios.get("http://localhost:8080/products");
    return data;
  } catch (error) {
    console.log(error);
  }
}
export async function createProduct(name, price, description) {
  try {
    const data = await axios.post("http://localhost:8080/products", {
      name: name,
      price: price,
      description: description,
    });
  } catch (error) {
    console.log(error);
  }
}

export async function deleteProduct(id) {
  try {
    const data = await axios.delete("http://localhost:8080/products/" + id);
  } catch (error) {
    console.log(error);
  }
}
// export async function updateProduct(id, name, price, description) {
//   try {
//     const data = await axios.put("http://localhost:8080/products", {
//       id: id,
//       name: name,
//       price: price,
//       description: description,
//     });
//   } catch (error) {
//     console.log(error);
//   }
// }
