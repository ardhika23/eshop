# 📝Tutorial & Exercise📝

**Student Details :**

|  `Attribute`  | `Information`                          |
|---------------|----------------------------------------|
| Name          | Ardhika Satria Narendra                |
| Student ID    | 2206821866                             |
| Class         | Advanced Programming KKI               |
| Website URL   | https://github.com/ardhika23/eshop.git |

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