<template>
  <div class="container">
    <table id="tblUsers">
      <thead>
        <tr>
          <th>
            <input
              type="checkbox"
              id="selectAll"
              @change="toggleSelectAll"
              :checked="
                selectedUsers.length === filteredList.length &&
                filteredList.length > 0
              "
            />
          </th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Username</th>
          <th>Email Address</th>
          <th>Status</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>&nbsp;</td>
          <td>
            <input
              type="text"
              name="firstNameFilter"
              v-model="filter.firstName"
            />
          </td>
          <td>
            <input
              type="text"
              name="lastNameFilter"
              v-model="filter.lastName"
            />
          </td>
          <td>
            <input
              type="text"
              name="usernameFilter"
              v-model="filter.username"
            />
          </td>
          <td>
            <input
              type="text"
              name="emailAddressFilter"
              v-model="filter.emailAddress"
            />
          </td>
          <td>
            <select v-model="filter.status">
              <option value>Show All</option>
              <option value="Active">Active</option>
              <option value="Inactive">Inactive</option>
            </select>
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr
          v-for="user in filteredList"
          :key="user.id"
          :class="{ deactivated: user.status === 'Inactive' }"
        >
          <td :id="user.id" :value="user.id">
            <input
              type="checkbox"
              v-model="selectedUsers"
              :value="user.id"
              :id="'user-' + user.id"
            />
          </td>
          <td>{{ user.firstName }}</td>
          <td>{{ user.lastName }}</td>
          <td>{{ user.username }}</td>
          <td>{{ user.emailAddress }}</td>
          <td>{{ user.status }}</td>
          <td>
            <button @click="toggleUserStatus(user.id)">
              {{ user.status === "Active" ? "Deactivate" : "Activate" }}
            </button>
          </td>
        </tr>
      </tbody>
    </table>

    <div class="all-actions">
      <button
        id="btnActivateUsers"
        @click="activateSelectedUsers"
        :disabled="selectedUsers.length === 0"
      >
        Activate Users
      </button>
      <button
        id="btnDeactivateUsers"
        @click="deactivateSelectedUsers"
        :disabled="selectedUsers.length === 0"
      >
        Deactivate Users
      </button>
      <button
        id="btnDeleteUsers"
        @click="deleteSelectedUsers"
        :disabled="selectedUsers.length === 0"
      >
        Delete Users
      </button>
    </div>

    <button id="btnAddUser" @click="toggleForm">Add New User</button>

    <form id="frmAddNewUser" v-show="showForm" @submit.prevent="addUser">
      <div class="field">
        <label for="firstName">First Name:</label>
        <input
          type="text"
          name="firstName"
          id="firstName"
          v-model="newUser.firstName"
          required
        />
      </div>
      <div class="field">
        <label for="lastName">Last Name:</label>
        <input
          type="text"
          name="lastName"
          id="lastName"
          v-model="newUser.lastName"
          required
        />
      </div>
      <div class="field">
        <label for="username">Username:</label>
        <input
          type="text"
          name="username"
          id="username"
          v-model="newUser.username"
          required
        />
      </div>
      <div class="field">
        <label for="emailAddress">Email Address:</label>
        <input
          type="text"
          name="emailAddress"
          id="emailAddress"
          v-model="newUser.emailAddress"
          required
        />
      </div>
      <button type="submit" class="btn save">Save User</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      showForm: false, // Form is hidden by default
      selectedUsers: [],
      filter: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "",
      },
      nextUserId: 7,
      newUser: {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active",
      },
      users: [
        {
          id: 1,
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active",
        },
        {
          id: 2,
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active",
        },
        {
          id: 3,
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive",
        },
        {
          id: 4,
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active",
        },
        {
          id: 5,
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active",
        },
        {
          id: 6,
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive",
        },
      ],
    };
  },
  methods: {
    toggleForm() {
      this.showForm = !this.showForm;
    },

    addUser() {
      if (
        this.newUser.firstName &&
        this.newUser.lastName &&
        this.newUser.username &&
        this.newUser.emailAddress
      ) {
        this.newUser.id = this.getNextUserId();
        this.users = [...this.users, { ...this.newUser }];
        this.clearForm();
        this.showForm = false;
      }
    },

    clearForm() {
      this.newUser = {
        id: null,
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "Active",
      };
    },

    toggleUserStatus(userId) {
      const user = this.users.find((user) => user.id === userId);
      if (user) {
        user.status = user.status === "Active" ? "Inactive" : "Active";
      }
    },

    toggleSelectAll() {
      if (this.selectedUsers.length === this.filteredList.length) {
        this.selectedUsers = [];
      } else {
        this.selectedUsers = this.filteredList.map((user) => user.id);
      }
    },

    activateSelectedUsers() {
      this.users.forEach((user) => {
        if (this.selectedUsers.includes(user.id)) user.status = "Active";
      });
      this.selectedUsers = [];
    },

    deactivateSelectedUsers() {
      this.users.forEach((user) => {
        if (this.selectedUsers.includes(user.id)) user.status = "Inactive";
      });
      this.selectedUsers = [];
    },

    deleteSelectedUsers() {
      this.users = this.users.filter(
        (user) => !this.selectedUsers.includes(user.id)
      );
      this.selectedUsers = [];
    },

    getNextUserId() {
      return this.nextUserId++;
    },
  },

  computed: {
    filteredList() {
      let filteredUsers = this.users;
      if (this.filter.firstName) {
        filteredUsers = filteredUsers.filter((user) =>
          user.firstName
            .toLowerCase()
            .includes(this.filter.firstName.toLowerCase())
        );
      }
      if (this.filter.lastName) {
        filteredUsers = filteredUsers.filter((user) =>
          user.lastName
            .toLowerCase()
            .includes(this.filter.lastName.toLowerCase())
        );
      }
      if (this.filter.username) {
        filteredUsers = filteredUsers.filter((user) =>
          user.username
            .toLowerCase()
            .includes(this.filter.username.toLowerCase())
        );
      }
      if (this.filter.emailAddress) {
        filteredUsers = filteredUsers.filter((user) =>
          user.emailAddress
            .toLowerCase()
            .includes(this.filter.emailAddress.toLowerCase())
        );
      }
      if (this.filter.status) {
        filteredUsers = filteredUsers.filter(
          (user) => user.status === this.filter.status
        );
      }

      return filteredUsers;
    },
  },
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.deactivated {
  color: red;
}
input,
select {
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
.field {
  padding: 10px 0px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}
.all-actions {
  margin-bottom: 40px;
}
.btn.save {
  margin: 20px;
  float: right;
}
</style>
