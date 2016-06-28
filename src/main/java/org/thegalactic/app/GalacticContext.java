package org.thegalactic.app;

/*
 * GalacticContext.java
 *
 * Copyright: 2010-2015 Karell Bertet, France
 * Copyright: 2015-2016 The Galactic Organization, France
 *
 * License: http://www.cecill.info/licences/Licence_CeCILL-B_V1-en.html CeCILL-B license
 *
 * This file is part of java-lattices.
 * You can redistribute it and/or modify it under the terms of the CeCILL-B license.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.kohsuke.args4j.OptionHandlerFilter.ALL;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.ParserProperties;

import org.thegalactic.context.Context;
import org.thegalactic.dgraph.DGraph;
import org.thegalactic.lattice.ConceptLattice;
import org.thegalactic.lattice.ImplicationalSystem;

/**
 * This class converts a context file to lattice file in dot format.
 */
public class GalacticContext {

    /**
     * input file.
     */
    @Option(name = "-i",
            usage = "input from this file",
            metaVar = "INPUT",
            aliases = {"--input"},
            required = true
    )
    private File in;

    /**
     * precedence file.
     */
    @Option(name = "-p",
            usage = "precedence graph",
            metaVar = "PRECEDENCE_GRAPH",
            aliases = {"--precedence"},
            required = false
    )
    private File precedence = new File("precedence-graph.dot");

    /**
     * next closure file.
     */
    @Option(name = "-n",
            usage = "closed set lattice with next closure",
            metaVar = "CLOSED_SET_LATTICE_NEXT_CLOSURE",
            aliases = {"--concept-lattice-next-closure"},
            required = false
    )
    private File nextClosure = new File("closed-set-lattice-next-closure.dot");

    /**
     * closed set lattice of the context with Bordat file.
     */
    @Option(name = "-b",
            usage = "closed set lattice of the context with Bordat",
            metaVar = "CLOSED_SET_LATTICE_BORDAT",
            aliases = {"--closed-set-lattice-Bordat"},
            required = false
    )
    private File closedSetLatticeBordat = new File("closed-set-lattice-Bordat.dot");

    /**
     * dependency graph.
     */
    @Option(name = "-d",
            usage = "dependence graph",
            metaVar = "DEPENDENCE_GRAPH",
            aliases = {"--dependence-graph"},
            required = false
    )
    private File dependenceGraph = new File("dependence-graph.dot");

    /**
     * minimal generators.
     */
    @Option(name = "-g",
            usage = "minimal generators",
            metaVar = "MINIMAL_GENERATORS",
            aliases = {"--minimal-generators"},
            required = false
    )
    private File minimalGenerators = new File("minimal-generators.txt");

    /**
     * canonical direct basis.
     */
    @Option(name = "-r",
            usage = "canonical direct basis",
            metaVar = "CANONICAL_DIRECT_BASIS",
            aliases = {"--canonical-direct-basis"},
            required = false
    )
    private File canonicalDirectBasis = new File("canonical-direct-basis.txt");

    /**
     * concept lattice of the context with Bordat file.
     */
    @Option(name = "-c",
            usage = "concept lattice of the context with Bordat",
            metaVar = "CONCEPT_LATTICE_BORDAT",
            aliases = {"--concept-lattice-Bordat"},
            required = false
    )
    private File conceptLatticeBordat = new File("concept-lattice-Bordat.dot");

    /**
     * table of the concept lattice of the context.
     */
    @Option(name = "-t",
            usage = "table of the concept lattice of the context",
            metaVar = "TABLE",
            aliases = {"--table"},
            required = false
    )
    private File table = new File("table.txt");

    /**
     * concept lattice of the context with Bordat file.
     */
    @Option(name = "-a",
            usage = "context reduced",
            metaVar = "REDUCED_CONTEXT",
            aliases = {"--context-reduced"},
            required = false
    )
    private File reduceContext = new File("reduced-context.txt");

    /**
     * Main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new GalacticContext().doMain(args);
    }

    /**
     * Execute command line arguments.
     *
     * @param args command line arguments
     */
    public void doMain(String[] args) {
        ParserProperties properties = ParserProperties.defaults();
        properties.withOptionSorter(null);
        CmdLineParser parser = new CmdLineParser(this, properties);

        // if you have a wider console, you could increase the value;
        // here 80 is also the default
        parser.getProperties().withUsageWidth(80);

        try {
            // parse the arguments.
            parser.parseArgument(args);
        } catch (CmdLineException ex) {
            // if there's a problem in the command line,
            // you'll get this exception. this will report
            // an error message.
            System.err.println("galactic-context [options...]");
            // print the list of available options
            parser.printUsage(System.err);
            System.err.println();

            // print option sample. This is useful some time
            System.err.println("  Example: galactic-context" + parser.printExample(ALL));

            return;
        }
        try {
            Context ctx = new Context(in.getPath());
            if (precedence != null) {
                DGraph graph = ctx.precedenceGraph();
                graph.save(precedence.getPath());
            }
            if (nextClosure != null) {
                ConceptLattice lattice = ctx.closedSetLattice(false);
                lattice.save(nextClosure.getPath());
            }
            if (closedSetLatticeBordat != null) {
                ConceptLattice lattice = ctx.closedSetLattice(true);
                lattice.save(closedSetLatticeBordat.getPath());
                if (dependenceGraph != null) {
                    DGraph graph = lattice.getDependencyGraph();
                    graph.save(dependenceGraph.getPath());
                }
                if (minimalGenerators != null) {
                    final BufferedWriter file = new BufferedWriter(new FileWriter(minimalGenerators.getPath()));
                    file.write(lattice.getMinimalGenerators().toString());
                    file.close();
                }
                if (canonicalDirectBasis != null) {
                    ImplicationalSystem is = lattice.getCanonicalDirectBasis();
                    is.save(canonicalDirectBasis.getPath());
                }
            }
            if (conceptLatticeBordat != null) {
                ConceptLattice lattice = ctx.conceptLattice(true);
                lattice.save(closedSetLatticeBordat.getPath());
                if (table != null) {
                    Context reduced = lattice.getTable();
                    reduced.save(table.getPath());
                }
            }
            if (reduceContext != null) {
                ctx.reduction();
                ctx.save(reduceContext.getPath());
            }
        } catch (Exception ex) {
            Logger.getLogger(GalacticContext.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
    }
}
