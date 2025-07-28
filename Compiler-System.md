# Compiler System

> **Relevant source files**
> * [.idea/misc.xml](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml)
> * [ComplierForMIDL.iml](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/ComplierForMIDL.iml)

## Purpose and Scope

This document covers the core MIDL compiler architecture, including the main module structure, ANTLR framework integration, and language processing pipeline. The compiler system implements a complete MIDL language processor using Java and ANTLR 4.13.1.

For detailed information about the IntelliJ IDEA development environment setup, see [IntelliJ IDEA Configuration](/yanzhe-Xiao/My-First-Complier-Work/3.1-intellij-idea-configuration). For build configuration specifics, see [Module Configuration](/yanzhe-Xiao/My-First-Complier-Work/2.1-module-configuration).

## Core Architecture

The MIDL compiler system is built around a modular Java architecture that leverages ANTLR for automated parser generation. The system consists of grammar definitions, generated language processing components, and a main compiler module.

### System Components Overview

```mermaid
flowchart TD

MIDLGrammar["MIDLGrammar.g4"]
MIDLLexer_G4["MIDLLexer.g4"]
ANTLR_Tool["antlr-4.13.1-complete.jar"]
AutoGen["Auto Generation Enabled"]
MIDLLexer_Java["MIDLLexer.java"]
MIDLGrammarParser["MIDLGrammarParser.java"]
MIDLVisitor["MIDLVisitor.java"]
ComplierForMIDL_Module["ComplierForMIDL.iml"]
SRC_Folder["src/"]
OUT_Folder["out/"]
JDK21["JDK 21"]
JavaSDK["JavaSDK"]

MIDLGrammar --> ANTLR_Tool
MIDLLexer_G4 --> ANTLR_Tool
ANTLR_Tool --> MIDLLexer_Java
ANTLR_Tool --> MIDLGrammarParser
ANTLR_Tool --> MIDLVisitor
MIDLLexer_Java --> SRC_Folder
MIDLGrammarParser --> SRC_Folder
MIDLVisitor --> SRC_Folder
ComplierForMIDL_Module --> ANTLR_Tool
JavaSDK --> ComplierForMIDL_Module

subgraph Runtime_Environment ["Runtime_Environment"]
    JDK21
    JavaSDK
    JDK21 --> JavaSDK
end

subgraph Module_Structure ["Module_Structure"]
    ComplierForMIDL_Module
    SRC_Folder
    OUT_Folder
    ComplierForMIDL_Module --> SRC_Folder
    ComplierForMIDL_Module --> OUT_Folder
end

subgraph Generated_Components ["Generated_Components"]
    MIDLLexer_Java
    MIDLGrammarParser
    MIDLVisitor
end

subgraph ANTLR_Generation ["ANTLR_Generation"]
    ANTLR_Tool
    AutoGen
    AutoGen --> ANTLR_Tool
end

subgraph Grammar_Definitions ["Grammar_Definitions"]
    MIDLGrammar
    MIDLLexer_G4
end
```

**Sources:** [.idea/misc.xml L1-L32](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml#L1-L32)

 [ComplierForMIDL.iml L1-L20](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/ComplierForMIDL.iml#L1-L20)

## Language Processing Pipeline

The compiler implements a traditional three-phase language processing pipeline using ANTLR-generated components. Each phase corresponds to a specific generated Java class that handles lexical analysis, syntactic analysis, and semantic processing.

### ANTLR Processing Flow

```mermaid
flowchart TD

MIDL_Source["MIDL Source Files"]
MIDLLexer_Class["MIDLLexer.java"]
TokenStream["Token Stream"]
MIDLGrammarParser_Class["MIDLGrammarParser.java"]
ParseTree["Parse Tree"]
MIDLVisitor_Class["MIDLVisitor.java"]
TreeWalking["Tree Walking"]
CompiledOutput["Compiled Output"]

MIDL_Source --> MIDLLexer_Class
TokenStream --> MIDLGrammarParser_Class
ParseTree --> MIDLVisitor_Class
TreeWalking --> CompiledOutput

subgraph Output_Generation ["Output_Generation"]
    CompiledOutput
end

subgraph Semantic_Analysis ["Semantic_Analysis"]
    MIDLVisitor_Class
    TreeWalking
    MIDLVisitor_Class --> TreeWalking
end

subgraph subGraph2 ["Syntactic_Analysis"]
    MIDLGrammarParser_Class
    ParseTree
    MIDLGrammarParser_Class --> ParseTree
end

subgraph Lexical_Analysis ["Lexical_Analysis"]
    MIDLLexer_Class
    TokenStream
    MIDLLexer_Class --> TokenStream
end

subgraph Input_Layer ["Input_Layer"]
    MIDL_Source
end
```

**Sources:** [.idea/misc.xml L7-L25](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml#L7-L25)

## Module Configuration

The `ComplierForMIDL` module defines the core structure and dependencies for the compiler system. The module uses the standard Java module format with specific ANTLR library integration.

### Module Dependencies and Structure

| Component | Configuration | Value |
| --- | --- | --- |
| Module Type | `JAVA_MODULE` | Standard Java module |
| Source Directory | `sourceFolder` | `$MODULE_DIR$/src` |
| Output Directory | `output` | `$PROJECT_DIR$/out` |
| JDK Version | `languageLevel` | `JDK_21` |
| ANTLR Library | `module-library` | `antlr-4.13.1-complete.jar` |

The module configuration specifies that generated ANTLR components are placed directly in the `src` folder alongside custom Java source code.

**Sources:** [ComplierForMIDL.iml L2-L19](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/ComplierForMIDL.iml#L2-L19)

 [.idea/misc.xml L29-L31](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml#L29-L31)

## ANTLR Generation Configuration

The ANTLR integration is configured through IntelliJ IDEA's ANTLR plugin with specific generation preferences for both grammar files. The system uses automatic generation with visitor pattern support.

### Grammar File Configuration

```mermaid
flowchart TD

MIDLGrammar_G4["MIDLGrammar.g4<br>Main Grammar"]
MIDLLexer_G4["MIDLLexer.g4<br>Lexer Rules"]
AutoGen_True["autoGen: true"]
GenerateVisitor_True["generateVisitor: true"]
OutputDir["outputDir: src/"]
Lexer_Output["MIDLLexer.java"]
Parser_Output["MIDLGrammarParser.java"]
Visitor_Output["MIDLVisitor.java"]

MIDLGrammar_G4 --> AutoGen_True
MIDLLexer_G4 --> AutoGen_True
OutputDir --> Lexer_Output
OutputDir --> Parser_Output
OutputDir --> Visitor_Output

subgraph Generated_Artifacts ["Generated_Artifacts"]
    Lexer_Output
    Parser_Output
    Visitor_Output
end

subgraph Generation_Settings ["Generation_Settings"]
    AutoGen_True
    GenerateVisitor_True
    OutputDir
    AutoGen_True --> GenerateVisitor_True
    GenerateVisitor_True --> OutputDir
end

subgraph Grammar_Files ["Grammar_Files"]
    MIDLGrammar_G4
    MIDLLexer_G4
end
```

Both grammar files (`MIDLGrammar.g4` and `MIDLLexer.g4`) are configured with identical generation settings: automatic generation enabled, visitor pattern generation enabled, and output directed to the `src` directory.

**Sources:** [.idea/misc.xml L3-L28](https://github.com/yanzhe-Xiao/My-First-Complier-Work/blob/f0d8f425/.idea/misc.xml#L3-L28)