<template>
  <table id="tblUsers">
    <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
      <!-- Filter row -->
      <tr>
        <td>
          <input
            type="text"
            id="firstNameFilter"
            v-model="search.firstName"
            placeholder="Search First Name"
          />
        </td>
        <td>
          <input
            type="text"
            id="lastNameFilter"
            v-model="search.lastName"
            placeholder="Search Last Name"
          />
        </td>
        <td>
          <input
            type="text"
            id="usernameFilter"
            v-model="search.username"
            placeholder="Search Username"
          />
        </td>
        <td>
          <input
            type="text"
            id="emailFilter"
            v-model="search.emailAddress"
            placeholder="Search Email Address"
          />
        </td>
        <td>
          <select id="statusFilter" v-model="search.status">
            <option value="">Show All</option>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
          </select>
        </td>
      </tr>

      <!-- User rows (filtered in real time) -->
      <tr
        v-for="(user, index) in filteredList"
        :key="index"
        :class="{ inactive: user.status === 'Inactive' }"
      >
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.emailAddress }}</td>
        <td>{{ user.status }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  data() {
    return {
      users: [
        {
          firstName: "John",
          lastName: "Smith",
          username: "jsmith",
          emailAddress: "jsmith@gmail.com",
          status: "Active",
        },
        {
          firstName: "Anna",
          lastName: "Bell",
          username: "abell",
          emailAddress: "abell@yahoo.com",
          status: "Active",
        },
        {
          firstName: "George",
          lastName: "Best",
          username: "gbest",
          emailAddress: "gbest@gmail.com",
          status: "Inactive",
        },
        {
          firstName: "Ben",
          lastName: "Carter",
          username: "bcarter",
          emailAddress: "bcarter@gmail.com",
          status: "Active",
        },
        {
          firstName: "Katie",
          lastName: "Jackson",
          username: "kjackson",
          emailAddress: "kjackson@yahoo.com",
          status: "Active",
        },
        {
          firstName: "Mark",
          lastName: "Smith",
          username: "msmith",
          emailAddress: "msmith@foo.com",
          status: "Inactive",
        },
      ],
      search: {
        firstName: "",
        lastName: "",
        username: "",
        emailAddress: "",
        status: "",
      },
    };
  },
  computed: {
    filteredList() {
      return this.users.filter((user) => {
        const firstNameMatch =
          !this.search.firstName ||
          user.firstName
            .toLowerCase()
            .includes(this.search.firstName.toLowerCase());
        const lastNameMatch =
          !this.search.lastName ||
          user.lastName
            .toLowerCase()
            .includes(this.search.lastName.toLowerCase());
        const usernameMatch =
          !this.search.username ||
          user.username
            .toLowerCase()
            .includes(this.search.username.toLowerCase());
        const emailMatch =
          !this.search.emailAddress ||
          user.emailAddress
            .toLowerCase()
            .includes(this.search.emailAddress.toLowerCase());
        const statusMatch =
          !this.search.status ||
          user.status.toLowerCase() === this.search.status.toLowerCase();

        return (
          firstNameMatch &&
          lastNameMatch &&
          usernameMatch &&
          emailMatch &&
          statusMatch
        );
      });
    },
  },
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.inactive {
  color: red;
}
input,
select {
  font-size: 16px;
}
</style>
