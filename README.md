# Camping Checklist App 

This is a JavaFX desktop application that helps you manage camping inventory checklists across multiple categories. I chose this for the project as I have a camping trip next weekend with my dog.
Since there are several different groupings of inventory needed, I thought it would nicely fill the project requirements to break the inventory checklist into three separate categories, one for 
packing of camping needs, one for food / water, and one for my dog. The program gives you the option to add or remove items from the checklist as needed.

---

##  Features

- 📋 Three separate checklists:
  - Packing List
  - Dog List
  - Food List
-  Custom UI styling
-  Fade-in animations when opening checklist windows
- ⌨️ Keyboard shortcuts for fast access:
  - **Ctrl + P** → Open Packing List
  - **Ctrl + D** → Open Dog List
  - **Ctrl + F** → Open Food List

---

## How to Run

1. Open the project in your Java IDE
2. 2. Make sure JavaFX is correctly configured (add JavaFX libraries to your project).
3. Run the `MainApplication.java` class.

## Class Overview

| Class | Description |

* | `ChecklistItem` | Represents a single checklist item with properties (e.g., name, packed status). |
* | `ChecklistViewController` | Manages the checklist window UI. Handles loading items from CSV, moving between "Need to Pack" and "Packed" lists. |
* | `MainApplication` | Main JavaFX Application class. Loads the Main Menu, applies CSS styles, and shows the launcher window. |
* | `MainMenuController` | Controls the Main Menu screen: opens checklist windows on button click, sets up keyboard shortcuts. |
* | `module-info.java` | Java module declaration file listing JavaFX modules used by the project. |

---

## Notes

- CSV files (`packing_list.csv`, `dog_list.csv`, `food_list.csv`) are placed under the `/resources` folder.
- Styles are defined in `styles.css` and applied to all windows.
- Keyboard shortcuts are configured in `MainMenuController` using the JavaFX Scene's accelerators.
- Transitions are created with JavaFX `FadeTransition`.

## Screenshots

### Main Menu
![main_menu](https://github.com/user-attachments/assets/99fa169f-7230-4e45-84b7-2cfee7fb7342)

### Dog List
![dog_list](https://github.com/user-attachments/assets/22fdca54-05eb-40a1-bb35-bc0da571e08c)

### Food List
![food_list](https://github.com/user-attachments/assets/25d55563-d6c8-41fd-a4f6-401b951fe7f6)

### Packing List
![packing_list](https://github.com/user-attachments/assets/cb296621-678b-45f3-96bc-25cbd67d90bc)

### Oscar
![Oscar](https://github.com/user-attachments/assets/3e736e1d-bc8f-4607-b013-e6360491d239)



---

##  Author

- Patrick Swift

---
