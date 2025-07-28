[![Ask DeepWiki](https://deepwiki.com/badge.svg)](https://deepwiki.com/yanzhe-Xiao/My-First-Complier-Work)

# Overview
Relevant source files
This document provides a comprehensive overview of the MIDL Compiler project, an experimental compiler implementation built using Java and the ANTLR parser generator framework. The project demonstrates modern compiler construction techniques through a structured development environment and automated code generation pipeline.

For detailed information about the core compiler system architecture, see Compiler System. For development environment configuration details, see Development Environment. For supporting tools and utilities, see Tools and Utilities.

Project Purpose and Architecture
The MIDL Compiler serves as an experimental implementation for processing MIDL (Interface Definition Language) source code through a complete compilation pipeline. The system leverages ANTLR 4.13.1 for automatic generation of lexical analyzers, parsers, and syntax tree visitors.

The project follows a standard Java module structure with integrated ANTLR support:

Module Definition: The ComplierForMIDL.iml file defines the Java module configuration with ANTLR library dependencies
Source Organization: The src/ directory contains both custom Java source code and ANTLR-generated grammar files
Documentation: Project documentation resides in the document~ directory with Chinese language support
Code Metrics: Visual code statistics are maintained through the 代码量.png image referenced in the README
Key Directory Structure

The project implements an experimental compiler development approach with:

Grammar-First Design: ANTLR grammar files (.g4) define the MIDL language syntax and lexical rules
Automatic Code Generation: The ANTLR framework generates MIDLLexer, MIDLGrammarParser, and MIDLVisitor classes
Integrated Build System: IntelliJ IDEA module configuration manages dependencies and compilation
Documentation-Driven Development: Comprehensive documentation in Chinese with visual code metrics tracking
This architecture enables rapid prototyping and experimentation with compiler implementation techniques while maintaining a professional development environment structure.
