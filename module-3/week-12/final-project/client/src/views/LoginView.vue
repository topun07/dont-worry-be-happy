<template>
  <div id="login">
    <form v-on:submit.prevent="login">
      <div class="login-table">
        <div class="login-cell">
          <label for="username">Username</label>
          <input
            type="text"
            id="username"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
        </div>
        <div class="login-cell">
          <label for="password">Password</label>
          <input
            type="password"
            id="password"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </div>
      </div>
      <div id="login-button-container">
        <button id="login-button" type="submit">Sign In</button>
      </div>
      <hr />
      <footer id="login-footer">
        Don't have an account?
        <router-link v-bind:to="{ name: 'register' }">Create one!</router-link>
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
        password: "",
      },
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;
          if (!response) {
            alert(error);
          } else if (response.status === 401) {
            alert("Invalid username and password!");
          } else {
            alert(response.message);
          }
        });
    },
  },
};
</script>

<style scoped>
#login {
  background: linear-gradient(to bottom, #ffd700, #cc5500);
  min-height: 650px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 20px;
  position: relative;
}

#login-logo {
  position: absolute;
  top: 20px;
  right: 20px;
  width: 400px;
  height: 70px;
}

#login-header,
#login-footer {
  background-color: black;
  color: white;
  text-align: center;
  font-size: 1.5rem;
  padding: 10px;
  margin-bottom: 10px;
}

.login-table {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 20px;
  width: 60%;
  max-width: 600px;
  margin: 20px auto;
  border: 10px solid black;
  padding: 40px;
  background: white;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-cell {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.login-cell input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

#login-button-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

#login-button {
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
