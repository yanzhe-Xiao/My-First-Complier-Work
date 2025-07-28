# IntelliJ IDEA Configuration

> **Relevant source files**
> * [.idea/misc.xml](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml)
> * [.idea/modules.xml](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/modules.xml)
> * [.idea/uiDesigner.xml](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/uiDesigner.xml)

## Purpose and Scope

This document details the IntelliJ IDEA IDE configuration for the MIDL Compiler project, covering project structure setup, ANTLR integration, and development environment settings. The configuration enables automatic code generation from grammar files, GUI development with Swing components, and proper Java development workflow.

For information about the core compiler module setup, see [Module Configuration](/yanzhe-Xiao/My-First-Complier-Work/2.1-module-configuration). For details about GUI component implementation, see [GUI Components](/yanzhe-Xiao/My-First-Complier-Work/2.3-gui-components).

## Project Structure and Module Management

The IntelliJ IDEA project is configured as a single-module Java application with specific settings for ANTLR integration and Swing GUI development.

### Module Configuration Overview

```mermaid
flowchart TD

PROJ_ROOT["ComplierForMIDL Project Root"]
MODULE_MGR["ProjectModuleManager"]
IML_FILE["ComplierForMIDL.iml"]
SRC_DIR["src/ Source Directory"]
OUT_DIR["out/ Output Directory"]
G4_DIR["src/G4/ Grammar Files"]
JDK_21["Java SDK 21"]
MODULES_XML[".idea/modules.xml"]
MISC_XML[".idea/misc.xml"]
PROJ_ROOT_MGR["ProjectRootManager"]

MODULE_MGR --> MODULES_XML
PROJ_ROOT_MGR --> JDK_21
PROJ_ROOT_MGR --> OUT_DIR
IML_FILE --> SRC_DIR

subgraph subGraph2 ["Configuration Files"]
    MODULES_XML
    MISC_XML
    PROJ_ROOT_MGR
    MISC_XML --> PROJ_ROOT_MGR
end

subgraph subGraph1 ["Module Structure"]
    SRC_DIR
    OUT_DIR
    G4_DIR
    JDK_21
    SRC_DIR --> G4_DIR
end

subgraph subGraph0 ["Project Configuration"]
    PROJ_ROOT
    MODULE_MGR
    IML_FILE
    PROJ_ROOT --> MODULE_MGR
    MODULE_MGR --> IML_FILE
end
```

The project uses a single module configuration defined in [ComplierForMIDL.iml](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/ComplierForMIDL.iml)

 and registered through the `ProjectModuleManager` component. The module structure points to standard Java project directories with special handling for ANTLR grammar files in the `G4` subdirectory.

**Sources:** [.idea/modules.xml L1-L8](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/modules.xml#L1-L8)

 [.idea/misc.xml L29-L31](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml#L29-L31)

### Java SDK and Output Configuration

The project is configured to use Java Development Kit version 21 as the primary language level. The build output is directed to the `out/` directory at the project root.

| Configuration Component | Setting | Value |
| --- | --- | --- |
| `ProjectRootManager` | `languageLevel` | `JDK_21` |
| `ProjectRootManager` | `project-jdk-name` | `21` |
| `ProjectRootManager` | `project-jdk-type` | `JavaSDK` |
| `ProjectRootManager` | `output url` | `file://$PROJECT_DIR$/out` |

**Sources:** [.idea/misc.xml L29-L31](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml#L29-L31)

## ANTLR Integration and Code Generation

The IDE is configured with comprehensive ANTLR support for automatic code generation from grammar files. This configuration enables seamless development of the lexer and parser components.

### ANTLR Generation Settings

```mermaid
flowchart TD

MIDL_GRAMMAR["MIDLGrammar.g4"]
MIDL_LEXER["MIDLLexer.g4"]
AUTO_GEN["autoGen: true"]
OUTPUT_DIR["outputDir: src/"]
VISITOR_GEN["generateVisitor: true"]
PARSER_JAVA["MIDLGrammarParser.java"]
LEXER_JAVA["MIDLLexer.java"]
VISITOR_JAVA["MIDLVisitor.java"]
PREF_COMPONENT["ANTLRGenerationPreferences Component"]
PER_GRAMMAR["PerGrammarGenerationSettings"]

MIDL_GRAMMAR --> AUTO_GEN
MIDL_LEXER --> AUTO_GEN
VISITOR_GEN --> PARSER_JAVA
VISITOR_GEN --> LEXER_JAVA
VISITOR_GEN --> VISITOR_JAVA
PER_GRAMMAR --> AUTO_GEN

subgraph ANTLRGenerationPreferences ["ANTLRGenerationPreferences"]
    PREF_COMPONENT
    PER_GRAMMAR
    PREF_COMPONENT --> PER_GRAMMAR
end

subgraph subGraph2 ["Generated Artifacts"]
    PARSER_JAVA
    LEXER_JAVA
    VISITOR_JAVA
end

subgraph subGraph1 ["Generation Settings"]
    AUTO_GEN
    OUTPUT_DIR
    VISITOR_GEN
    AUTO_GEN --> OUTPUT_DIR
    OUTPUT_DIR --> VISITOR_GEN
end

subgraph subGraph0 ["Grammar Files"]
    MIDL_GRAMMAR
    MIDL_LEXER
end
```

The ANTLR integration uses the `ANTLRGenerationPreferences` component with individual `PerGrammarGenerationSettings` for each grammar file. Both grammar files are configured with identical generation parameters for consistency.

**Sources:** [.idea/misc.xml L3-L28](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml#L3-L28)

### Per-Grammar Configuration Details

The ANTLR configuration includes two grammar file configurations:

**MIDLGrammar.g4 Configuration:**

* File path: `$PROJECT_DIR$/src/G4/MIDLGrammar.g4`
* Auto-generation: Enabled
* Output directory: `C:\Code\IdeaProjects\ComplierForMIDL\src`
* Visitor generation: Enabled

**MIDLLexer.g4 Configuration:**

* File path: `$PROJECT_DIR$/src/G4/MIDLLexer.g4`
* Auto-generation: Enabled
* Output directory: `C:\Code\IdeaProjects\ComplierForMIDL\src`
* Visitor generation: Enabled

Both configurations use empty values for `libDir`, `encoding`, `pkg`, and `language` parameters, relying on ANTLR defaults.

**Sources:** [.idea/misc.xml L6-L25](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml#L6-L25)

## GUI Designer Configuration

The IDE includes comprehensive Swing GUI designer support through the `uiDesigner.xml` configuration. This enables visual development of the compiler's user interface components.

### Swing Component Palette Configuration

```mermaid
flowchart TD

SWING_GROUP["Swing Group"]
UI_DESIGNER["uiDesigner.xml"]
HSPACER["HSpacer"]
VSPACER["VSpacer"]
JPANEL["JPanel"]
JSCROLLPANE["JScrollPane"]
JBUTTON["JButton"]
JRADIOBUTTON["JRadioButton"]
JCHECKBOX["JCheckBox"]
JTEXTFIELD["JTextField"]
JPASSWORDFIELD["JPasswordField"]
JLABEL["JLabel"]
JTEXTAREA["JTextArea"]
JTEXTPANE["JTextPane"]
JEDITORPANE["JEditorPane"]
JTABLE["JTable"]
JCOMBOBOX["JComboBox"]
JLIST["JList"]
JTREE["JTree"]
JTABBEDPANE["JTabbedPane"]
JSPLITPANE["JSplitPane"]

SWING_GROUP --> HSPACER
SWING_GROUP --> VSPACER
SWING_GROUP --> JPANEL
SWING_GROUP --> JSCROLLPANE
SWING_GROUP --> JBUTTON
SWING_GROUP --> JRADIOBUTTON
SWING_GROUP --> JCHECKBOX
SWING_GROUP --> JTEXTFIELD
SWING_GROUP --> JPASSWORDFIELD
SWING_GROUP --> JLABEL
SWING_GROUP --> JTEXTAREA
SWING_GROUP --> JTEXTPANE
SWING_GROUP --> JEDITORPANE
SWING_GROUP --> JTABLE
SWING_GROUP --> JCOMBOBOX
SWING_GROUP --> JLIST
SWING_GROUP --> JTREE
SWING_GROUP --> JTABBEDPANE
SWING_GROUP --> JSPLITPANE

subgraph subGraph4 ["Container Components"]
    JCOMBOBOX
    JLIST
    JTREE
    JTABBEDPANE
    JSPLITPANE
end

subgraph subGraph3 ["Display Components"]
    JLABEL
    JTEXTAREA
    JTEXTPANE
    JEDITORPANE
    JTABLE
end

subgraph subGraph2 ["Input Components"]
    JBUTTON
    JRADIOBUTTON
    JCHECKBOX
    JTEXTFIELD
    JPASSWORDFIELD
end

subgraph subGraph1 ["Layout Components"]
    HSPACER
    VSPACER
    JPANEL
    JSCROLLPANE
end

subgraph subGraph0 ["Palette2 Component"]
    SWING_GROUP
    UI_DESIGNER
    UI_DESIGNER --> SWING_GROUP
end
```

The GUI designer palette includes a comprehensive set of standard Swing components organized in a single "Swing" group. Each component includes default constraints for automatic layout management.

**Sources:** [.idea/uiDesigner.xml L3-L123](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/uiDesigner.xml#L3-L123)

### Component Default Constraints

The GUI designer configuration specifies default layout constraints for each Swing component type. Key component categories include:

| Component Category | Examples | Default Sizing Policy |
| --- | --- | --- |
| Spacer Components | `HSpacer`, `VSpacer` | Flexible sizing (policy 6) |
| Container Components | `JPanel`, `JScrollPane` | Expandable (policy 3,7) |
| Input Components | `JTextField`, `JButton` | Fixed height, flexible width |
| Display Components | `JLabel`, `JTextArea` | Context-dependent sizing |

All components include specific `vsize-policy`, `hsize-policy`, `anchor`, and `fill` settings to ensure consistent layout behavior in the GUI designer.

**Sources:** [.idea/uiDesigner.xml L5-L121](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/uiDesigner.xml#L5-L121)

## Configuration File Structure

The IntelliJ IDEA configuration is organized across three primary XML configuration files in the `.idea/` directory:

### Configuration Components Overview

```mermaid
flowchart TD

IDEA_DIR[".idea/ Directory"]
MISC_XML["misc.xml"]
MODULES_XML["modules.xml"]
UIDESIGNER_XML["uiDesigner.xml"]
ANTLR_PREFS["ANTLRGenerationPreferences"]
PROJECT_ROOT["ProjectRootManager"]
PROJECT_MODULE["ProjectModuleManager"]
MODULE_REF["ComplierForMIDL.iml Reference"]
PALETTE2["Palette2"]
SWING_COMPONENTS["Swing Component Definitions"]

MISC_XML --> ANTLR_PREFS
MISC_XML --> PROJECT_ROOT
MODULES_XML --> PROJECT_MODULE
UIDESIGNER_XML --> PALETTE2

subgraph subGraph3 ["uiDesigner.xml Components"]
    PALETTE2
    SWING_COMPONENTS
    PALETTE2 --> SWING_COMPONENTS
end

subgraph subGraph2 ["modules.xml Components"]
    PROJECT_MODULE
    MODULE_REF
    PROJECT_MODULE --> MODULE_REF
end

subgraph subGraph1 ["misc.xml Components"]
    ANTLR_PREFS
    PROJECT_ROOT
end

subgraph subGraph0 ["Project Configuration Structure"]
    IDEA_DIR
    MISC_XML
    MODULES_XML
    UIDESIGNER_XML
    IDEA_DIR --> MISC_XML
    IDEA_DIR --> MODULES_XML
    IDEA_DIR --> UIDESIGNER_XML
end
```

Each configuration file serves a distinct purpose in the IDE setup: `misc.xml` handles project-wide settings and ANTLR integration, `modules.xml` manages module structure, and `uiDesigner.xml` configures GUI development tools.

**Sources:** [.idea/misc.xml L1-L32](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml#L1-L32)

 [.idea/modules.xml L1-L8](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/modules.xml#L1-L8)

 [.idea/uiDesigner.xml L1-L124](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/uiDesigner.xml#L1-L124)