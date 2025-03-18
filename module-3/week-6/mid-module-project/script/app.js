document.addEventListener("DOMContentLoaded", function () {
  const productContainer = document.getElementById("product-cards");
  const searchBox = document.getElementById("search-box");
  const messageWindow = document.getElementById("message-window");

  function displayProducts(products) {
    productContainer.innerHTML = ""; // Clear existing cards

    products.forEach((product) => {
      // Create product card
      const productCard = document.createElement("article");
      productCard.classList.add("product-card");

      // SKU
      const sku = document.createElement("div");
      sku.classList.add("sku");
      sku.textContent = product.productSku;

      // Price (Formatted as currency)
      const price = document.createElement("div");
      price.classList.add("price");
      price.textContent = formatCurrency(product.price);

      // Product Name (Clickable)
      const productName = document.createElement("div");
      productName.classList.add("product-name", "action");
      productName.setAttribute("data-id", product.productId);
      productName.textContent = product.name;

      // Event handler for product name click
      productName.addEventListener("click", () => {
        showMessage(product.description);
      });

      // Product Image
      const productImageDiv = document.createElement("div");
      productImageDiv.classList.add("product-image");
      const img = document.createElement("img");
      img.setAttribute("src", product.imageName);
      img.setAttribute("alt", product.name);
      productImageDiv.appendChild(img);

      // Cart Icon (Clickable)
      const cartDiv = document.createElement("div");
      cartDiv.classList.add("cart");
      const cartIcon = document.createElement("i");
      cartIcon.classList.add("fa-solid", "fa-cart-plus", "icon", "action");
      cartIcon.setAttribute("title", "Add item to cart");

      // Event handler for cart icon click
      cartIcon.addEventListener("click", () => {
        showMessage(`"${product.name}" has been added to your cart!`);
      });

      cartDiv.appendChild(cartIcon);

      // Append elements to product card
      productCard.appendChild(sku);
      productCard.appendChild(price);
      productCard.appendChild(productName);
      productCard.appendChild(productImageDiv);
      productCard.appendChild(cartDiv);

      // Append product card to container
      productContainer.appendChild(productCard);
    });
  }

  // Function to format price as currency
  function formatCurrency(amount) {
    return new Intl.NumberFormat("en-US", {
      style: "currency",
      currency: "USD",
    }).format(amount);
  }

  // Function to display messages in the message window
  function showMessage(message) {
    messageWindow.textContent = message;
    messageWindow.classList.remove("hidden"); // Show message window
    clearTimeout(messageWindow.timeout); // Prevent multiple timeouts
    messageWindow.timeout = setTimeout(() => {
      messageWindow.classList.add("hidden"); // Hide after 3 seconds
    }, 3000);
  }

  // Initial display of all products
  displayProducts(productService.getProducts());

  // Event listener for search
  searchBox.addEventListener("keyup", function () {
    const searchTerm = searchBox.value.trim();
    if (searchTerm) {
      displayProducts(productService.searchProducts(searchTerm));
    } else {
      displayProducts(productService.getProducts());
    }
  });
});
