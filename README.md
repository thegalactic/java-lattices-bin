java-lattices-bin
=================

[![Issues](https://img.shields.io/github/issues-raw/thegalactic/java-lattices-bin.svg)](https://github.com/thegalactic/java-lattices-bin/issues)
[![Snapshot](http://img.shields.io/badge/snapshot-v2.0.0-orange.svg)](https://github.com/thegalactic/java-lattices-bin)
[![License](http://img.shields.io/badge/license-CeCILL--B-blue.svg)](http://www.cecill.info/licences/Licence_CeCILL-B_V1-en.html)

This package contains command line applications using the [java-lattices library](https://github.com/thegalactic/java-lattices).

Installation
------------

~~~
$ git clone https://github.com/thegalactic/java-lattices-bin.git
$ cd java-lattices-bin
$ mvn package
~~~

Usage
-----

~~~
$ ./target/appassembler/bin/galactic-context [options...]
 -i (--input)                           : input from this file
 -p (--precedence)                      : precedence graph
 -n (--closed-set-lattice-next-closure) : closed set lattice with next closure's algorithm
 -b (--closed-set-lattice-Bordat)       : closed set lattice with Bordat's algorithm
 -d (--dependence-graph)                : dependence graph
 -g (--minimal-generators)              : minimal generators
 -r (--canonical-direct-basis)          : canonical direct basis
 -c (--concept-lattice-Bordat)          : concept lattice with Bordat's algorithm
 -t (--table) TABLE                     : table of the concept lattice
 -a (--context-reduced)                 : context reduced
~~~

The options `-d`, `-g` and `-r` can only be used in conjunction with the option `-b`.

The option `-t` can only be used in conjunction with the option `-c`

You can use the dataset from http://www.upriss.org.uk/fca/examples.html. Special thanks to Uta Priss.

