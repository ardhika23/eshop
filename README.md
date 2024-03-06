# 📝Tutorial & Exercise📝

**Student Details :**

|  `Attribute`  | `Information`              |
|---------------|----------------------------|
| Name          | Ardhika Satria Narendra    |
| Student ID    | 2206821866                 |
| Class         | Advanced Programming KKI   |
| Website URL   | eshop-ardhika23.koyeb.app  |

---
<details>
<summary>Module 01: Coding Standards</summary>

## Questions and Answers

### -> Reflection 1 
When adding two new features to our Spring Boot application, I focused on writing clean code. I chose meaningful names for classes, methods, and variables to make the code easy to read and maintain. I made sure each function had a single purpose, which simplified debugging and testing. I also prioritized security by validating inputs to block injection attacks and encoding outputs to prevent XSS vulnerabilities. However, I later realized that our error handling could be better. By developing a more thorough exception handling strategy to address potential edge cases, we can enhance the robustness of our code and ensure it fails gracefully, thereby strengthening the application's security.

### -> Reflection 2

1. After creating unit tests, my confidence in the features' reliability and accuracy increased. Ideally, the number of unit tests for each class should cover all possible paths, including positive, negative, and edge case scenarios. Checking code coverage can indicate how comprehensive our tests are, but reaching 100% coverage doesn't mean our code is without flaws. It only shows that tests have run through every line of code, not necessarily capturing every possible scenario or combination of inputs. Therefore, while it's good to aim for high code coverage, it's more important to craft our tests carefully to explore various logical routes and potential errors.

2. In developing our new functional test suite that checks the product list's item count, I noticed that repeating setup steps and using the same variables across tests could clutter our code, leading to redundancy and making maintenance harder. This repetition goes against the DRY (Don't Repeat Yourself) principle and adds unnecessary complexity. To tackle this, I plan to consolidate common setup tasks and variables into a single base class or a setup method, marked with @Before or @BeforeEach, depending on which testing framework we're using. This strategy encourages reusing code, minimizes duplication, and helps keep our test suite clean and easy to manage.

</details>

---

<details>
<summary>Module 02: CI/CD & DevOps</summary>

## Questions and Answers

### -> Reflection 

1. During the exercise, I came across a few code quality issues that needed my attention. One problem was incomplete test coverage, especially in the repository and controller classes. To tackle this, I added more test cases to cover functionalities that were not tested initially, making sure our code has comprehensive coverage. Another issue popped up in what seemed like a simple closing curly bracket. On closer inspection, I realized the importance of a specific test case for scenarios where the product ID is not found. This improvement enhances the application's robustness.I also addressed the quality issue of an unused import. It was a quick fix, I simply delete the unnecessary import in Product.java. To tidy things up, I also removed some other unused imports in different files, making the code cleaner.

2. In my situation, the current solution meets the requirements of CI/CD. It fit the requirements of CI because I integrated my programme using testing tools such as OSSF Scorecard, JUnit, JaCoCo, and SonarCloud. Following the integration process, my app continuously distributes the most recent version of the app based on the repository, which meets the criteria of continuous deployment.

</details>

---

<details>
<summary>Module 03: OO Principles & Software Maintainability</summary>

## Questions and Answers

### -> Reflection

1. Explain what principles you apply to your project!

In the project, I apply the following SOLID principles:

- Single Responsibility Principle (SRP): Each class has a single reason to change, focusing on a single aspect of the system. For instance, the CarRepository class is dedicated to handling database operations for car entities, including creating, reading, updating, and deleting records.

- Open/Closed Principle (OCP): The system is designed to allow for extensions without modifying existing code. For example, the ProductService class's method for creating products is designed to handle new product IDs in a flexible manner, allowing for easy addition of new functionality.

- Liskov Substitution Principle (LSP): We ensure that subclasses can replace their superclass without affecting the application's correctness. This is exemplified by maintaining clear separation and functionality between CarController and ProductController, avoiding inheritance where it's not necessary to ensure substitutability.


2. Explain the advantages of applying SOLID principles to your project with examples.

Applying SOLID principles offers several advantages:

- Improved maintainability: By adhering to SRP, for example, the CarRepository class is focused solely on persistence operations related to cars. This makes it easier to understand, maintain, and modify without impacting other areas of the system.

- Enhanced scalability: The OCP facilitates the addition of new features without altering existing code. In the case of ProductService, new types of products can be added to the system with minimal changes, supporting scalability.

- Greater flexibility in development: LSP ensures that the system's components are interchangeable. For example, by separating CarController and ProductController, developers can introduce new controllers for different product types without altering the existing logic, providing flexibility.

3. Explain the disadvantages of not applying SOLID principles to your project with examples.

Not applying SOLID principles can lead to several disadvantages:

- Increased complexity and maintenance challenges: Without SRP, a class handling multiple responsibilities becomes complex and harder to maintain. Changes in one functionality might require changes in unrelated features, increasing the risk of bugs.

- Difficulty in extending functionality: Ignoring OCP means the system is not prepared for extensions without modifications to existing code. This can lead to a brittle architecture where adding new features requires changing existing functionalities, potentially introducing errors.

- Reduced flexibility and more fragile design: Not adhering to LSP can result in a design where subclasses cannot effectively replace their superclass, limiting the system's flexibility. This rigid structure makes it harder to evolve the system over time, as changes in base classes could necessitate widespread modifications throughout the codebase.

</details>

---

---
<details>
<summary>Module 04: Coding Standards</summary>

## Questions and Answers

### -> Reflection

1. Discussing test-driven development (TDD), I find Percival's (2017) methods to be highly beneficial to my career in development. Crafting tests prior to coding urged me to follow a systematic path and give extra importance to considering edge and specific cases. This led to my code gaining strength and the features I operated on became clearer. Still, I felt there were parts where I could have excelled more. To provide a thoroughness, my aim is to spend more time pondering over the scope of future tests and exploring different scenarios. This action will enhance the overall quality of my code whilst also minimizing time spent on debugs.

2. When I think back on the unit tests I took during the course, I think I mostly followed the F.I.R.S.T. guidelines. My testing were timely, healthy, isolated, rapid, and accurate. I am aware that I can always do better, though. For instance, there were dependent variables that might have impacted the outcomes, even if the two trials were as distinct from one another as possible. The next time, I want to make sure that every unit test operates independently of the others by further separating the tests. I'll also make an effort to make my tests more self-authenticating so that the results of passes and fails are completely reported without requiring manual interpretation. This will streamline the development process and enhance the automation of my test suite.

</details>

---