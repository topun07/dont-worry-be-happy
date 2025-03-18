<template>
  <div id="register">
    <img id="register-logo" src="/img/lion.png" alt="Logo" />

    <form v-on:submit.prevent="register">
      <div class="register-table">
        <div class="register-cell">
          <label for="username">Username</label>
          <input
            type="text"
            id="username"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
          <label for="name">Name</label>
          <input
            type="text"
            id="name"
            placeholder="Name"
            v-model="user.name"
            required
          />
        </div>
        <div class="register-cell">
          <label for="address">Address</label>
          <input
            type="text"
            id="address"
            placeholder="Address"
            v-model="user.address"
          />
          <label for="city">City</label>
          <input type="text" id="city" placeholder="City" v-model="user.city" />
          <label for="state">State</label>
          <input
            type="text"
            id="state"
            placeholder="State"
            v-model="user.stateCode"
            maxlength="2"
            required
          />
          <label for="zip">ZIP</label>
          <input
            type="text"
            id="zip"
            placeholder="ZIP"
            v-model="user.zip"
            required
            pattern="\d{5}"
            title="ZIP Code must be 5 digits"
          />
        </div>
        <div class="register-cell">
          <label for="password">Password</label>
          <input
            type="password"
            id="password"
            placeholder="Password"
            v-model="user.password"
            required
          />
          <label for="confirmPassword">Confirm Password</label>
          <input
            type="password"
            id="confirmPassword"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />
        </div>
      </div>
      <div id="register-button-container">
        <button id="register-button" type="submit">Create Account</button>
      </div>
      <hr />
      <!-- Updated Footer Section -->
      <footer id="register-footer">
        Have an account?
        <router-link v-bind:to="{ name: 'login' }">Sign in!</router-link>
      </footer>
    </form>
  </div>
</template>
<script>
import authService from "../services/AuthService";

export default {
  data() {
    return {
      user: {
        username: "",
        name: "",
        password: "",
        confirmPassword: "",
        address: "",
        city: "",
        stateCode: "",
        zip: "",
        role: "user",
      },
    };
  },
  methods: {
    error(msg) {
      alert(msg);
    },
    success(msg) {
      alert(msg);
    },
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.error("Password & Confirm Password do not match");
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.success("Thank you for registering, please sign in.");
              this.$router.push({
                path: "/login",
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            if (!response) {
              this.error(error);
            } else if (response.status === 400) {
              if (response.data.errors) {
                // Show the validation errors
                let msg = "Validation error: ";
                for (let err of response.data.errors) {
                  msg += `'${err.field}':${err.defaultMessage}. `;
                }
                this.error(msg);
              } else {
                this.error(response.data.message);
              }
            } else {
              this.error(response.data.message);
            }
          });
      }
    },
  },
};
</script>

<style scoped>
/* Style Header and Footer */
#register-header,
#register-footer {
  background-color: black;
  color: white;
  text-align: center;
  font-size: 1.5rem;
  padding: 10px;
  margin-bottom: 10px;
}

/* background*/
#register {
  background: linear-gradient(to bottom, #ffd700, #cc5500);
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 20px;
  position: relative;
}

/* Logo styling */
#register-logo {
  position: absolute;
  top: 20px;
  right: 20px;
  width: 400px;
  height: 70px;
}

/* Table layout for the form fields */
.register-table {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
  width: 80%;
  max-width: 900px;
  margin: 20px auto;
  border: 20px solid black;
  padding: 40px;
  background: white;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.register-cell {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

/* Input field styling */
.register-cell input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

/* Pulsating 'Create Account' button */
#register-button-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

#register-button {
  background-color: #ffffff;
  font-size: 24px;
  padding: 15px 30px;
  border: none;
  border-radius: 10px;
  cursor: pointer;
  text-transform: uppercase;
  font-weight: bold;
  animation: pulse 1.5s infinite;
}

@keyframes pulse {
  0% {
    transform: scale(1);
    box-shadow: 0 0 5px #ffd700;
  }
  50% {
    transform: scale(1.1);
    box-shadow: 0 0 20px #ffd700;
  }
  100% {
    transform: scale(1);
    box-shadow: 0 0 5px #ffd700;
  }
}
</style>
