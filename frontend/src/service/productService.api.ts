import axios from "axios";
export async function getProduct() {
  try {
    const data = await axios.get("http://localhost:8080/products");
    console.log("mons service");
    return data;
  } catch (error) {
    console.log(error);
  }
}
