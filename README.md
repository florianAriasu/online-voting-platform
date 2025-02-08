## Online Voting Platform 🗳️

#### Classes 🏫
For this project I have implemented the following classes:

- Alegeri
- Circumscriptie
- Persoana (abstract class)
- Candidat (extends persoana)
- Votant (extends persoana)
- Vot
- FunctiiAuxiliare (aux methods)
- ManagerGeneralAlegeri (this class represents the core of the application)
- StagiuAlegeri (this is an enum declaring all 3 stages of the election)

#### Feature Description ⚙️

###### Data structures 🗃️
- HashMap<>
- ArrayList<>

###### Classes 📚
- I used a `manager` class because I would have created an instance of an `Alegeri` object redundantly whenever an error from the assignment statement occurred.
- Here, I have all the necessary methods to implement the functionality of the assignment.
- In the `Alegeri` class, I defined the necessary variables, constructor, and getters and setters.
- All the other classes follow the same pattern as `Alegeri`.
- I defined the `Enum` to avoid passing the stage type as a `String` argument when calling functions. It's not strictly necessary, but that's how I decided to implement it.
- `Persoana` is an abstract class because I do not explicitly create instances of `Persoana`, but only instances of `Votanti` or `Candidati`.
- `Votant` and `Candidat` extend `Persoana`

###### Reading Data 📖
- I handled the "reading" using a HashMap<>, but it allows duplicate values because the commands may repeat for error testing.  
- I read line by line and populate the HashMap, and then I simply iterate through it and extract the values, which are the commands from AppTest.java.

###### Method Calling 🔄
- I have used a switch statement and formatted the code as effectively as possible based on which method I want to call. This makes the code more readable. When the exit command (namely 18) is encountered, it directly exits the Run() method

###### OOP Principles 🧩
- `Encapsulation`
- `Abstraction`
- `Inheritance`
  
###### Comments 💬
- I avoided adding comments in the code to keep it clean.  
- I ensured that variable, method, and class names are all in a single language (Romanian) and followed standard Java formatting conventions to keep everything well-organized and consistent.  
- I focused on making variable and method names as descriptive as possible, so there would be no need to add comments for clarification.  

###### Bonus 🎁
- AppTest.java can be improved because it does not take the order of the results into account. Therefore, `all sorting` by CNP or number of votes are `redundant`.
- This happens because the `contains()` method is used.
- As a solution, I thought the result could be written as a block instead of sequentially, with results one after the other.
- Also, I would implement a feature to truly identify fraudulent voters, since even clumsy individuals would be categorized as fraudulent if they attempt to vote a second time, with their first vote not being counted. Meanwhile, fraudulent voters are actually at their second vote.

#### Tips for Running the Project ⚡
To run this project, you need to have **Gradle** installed on your local machine.  
> [!NOTE] 
> If you do not have Gradle installed, you can download it from [Gradle's official website](https://gradle.org/install/).

This project includes a `settings.gradle` file, which is used to configure the Gradle build.  
> [!NOTE] 
> Once you have Gradle installed, navigate to the project directory in your terminal and run the following command to install the required dependencies:
  ```bash
  gradle build
```

> [!TIP]
> #### Gradle Integration with IntelliJ IDEA 📦
> 
> The project includes the `gradle/wrapper` directory, allowing IntelliJ IDEA to automatically recognize it as a Gradle project. No additional plugins are required—just open the project, and access Gradle tasks from the sidebar

