# Tagcoder Plugin for IntelliJ IDE

The Tagcoder plugin is designed to enhance code smell detection capabilities within the IntelliJ IDE. 
It provides a user-friendly interface to capture user feedback on code smells, facilitating the process of fine-tuning machine-learning models based on user preferences and context. 
This plugin integrates seamlessly with the IntelliJ IDE, making it easier for developers to participate in the code smell detection process actively.

## Features

- User feedback capture: The plugin allows users to provide feedback on code smells detected by the IDE, enabling them to customize and refine the code smell detection process.
- Context-aware detection: By leveraging the user's specific context within the IDE, the plugin enables more accurate and personalized code smell identification.
- Seamless integration: The plugin seamlessly integrates with the IntelliJ IDE, providing a smooth and intuitive user experience.

## Prerequisites

- IntelliJ IDE (compatible with IntelliJ IDEA)
- Java 1.8

## Installation

- Install IDE
- Clone the GIT repository 

## Running

- Open the GIT repository in IntelliJ IDE.
- Open the settings dialog.
- Click on the plugin tab.
- Select the settings menu and click 'Install from disk.'
- Import the plugin file `IntelliJPlugin/TagmanPlugin-1.0-SNAPSHOT.zip'.  
- The repository that was presented to the users is present at:
  https://github.com/himesh13/Tagman_Phase2
- The raw data collected at the end of the experiment is present in the Experiment-Data folder named `results-exp.zip`. 

Alternative to importing the jar, you can also run the 'runIde' goal in Gradle. The gradle goal will automatically open a new instance of IDE with the plugin installed from the source.

## Acknowledgments

- [IntelliJ IDEA](https://www.jetbrains.com/idea/) and JetBrains for the development environment and plugin framework.
- [Hugging Face](https://huggingface.co/) for their contributions to the code smell detection models.

