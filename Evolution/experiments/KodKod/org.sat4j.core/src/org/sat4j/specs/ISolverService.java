/*******************************************************************************
 * SAT4J: a SATisfiability library for Java Copyright (C) 2004, 2012 Artois University and CNRS
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU Lesser General Public License Version 2.1 or later (the
 * "LGPL"), in which case the provisions of the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of the LGPL, and not to allow others to use your version of
 * this file under the terms of the EPL, indicate your decision by deleting
 * the provisions above and replace them with the notice and other provisions
 * required by the LGPL. If you do not delete the provisions above, a recipient
 * may use your version of this file under the terms of the EPL or the LGPL.
 *
 * Based on the original MiniSat specification from:
 *
 * An extensible SAT solver. Niklas Een and Niklas Sorensson. Proceedings of the
 * Sixth International Conference on Theory and Applications of Satisfiability
 * Testing, LNCS 2919, pp 502-518, 2003.
 *
 * See www.minisat.se for the original solver in C++.
 *
 * Contributors:
 *   CRIL - initial API and implementation
 *******************************************************************************/
package org.sat4j.specs;

/**
 * The aim on that interface is to allow power users to communicate with the SAT
 * solver using Dimacs format. That way, there is no need to know the internals
 * of the solver.
 * 
 * @author leberre
 * @since 2.3.2
 */
public interface ISolverService {

    /**
     * Ask the SAT solver to stop the search.
     */
    void stop();

    /**
     * Ask the SAT solver to backtrack. It is mandatory to provide a reason for
     * backtracking, in terms of literals (which should be falsified under
     * current assignment). The reason is not added to the clauses of the
     * solver: only the result of the analysis is stored in the learned clauses.
     * Note that these clauses may be removed latter.
     * 
     * @param reason
     *            a set of literals, in Dimacs format, currently falsified, i.e.
     *            for (int l : reason) assert truthValue(l) == Lbool.FALSE
     */
    void backtrack(int[] reason);

    /**
     * Add a new clause in the SAT solver. The new clause may contain new
     * variables. The clause may be falsified, in that case, the difference with
     * backtrack() is that the new clause is appended to the solver as a regular
     * clause. Thus it will not be removed by aggressive clause deletion. The
     * clause may be assertive at a given decision level. In that case, the
     * solver should backtrack to the proper decision level. In other cases, the
     * search should simply proceed.
     * 
     * @param literals
     *            a set of literals in Dimacs format.
     */
    void addClause(int[] literals);

    /**
     * To access the truth value of a specific literal under current assignment.
     * 
     * @param literal
     *            a Dimacs literal, i.e. a non-zero integer.
     * @return true or false if the literal is assigned, else undefined.
     */
    Lbool truthValue(int literal);

    /**
     * To access the current decision level
     */
    int currentDecisionLevel();

    /**
     * To access the literals propagated at a specific decision level.
     * 
     * @param decisionLevel
     *            a decision level between 0 and #currentDecisionLevel()
     */
    int[] getLiteralsPropagatedAt(int decisionLevel);

    /**
     * Suggests to the SAT solver to branch next on the given literal.
     * 
     * @param l
     *            a literal in Dimacs format.
     */
    void suggestNextLiteralToBranchOn(int l);

    /**
     * Read-Only access to the value of the heuristics for each variable. Note
     * that for efficiency reason, the real array storing the value of the
     * heuristics is returned. DO NOT CHANGE THE VALUES IN THAT ARRAY.
     * 
     * @return the value of the heuristics for each variable (using Dimacs
     *         index).
     */
    double[] getVariableHeuristics();

    /**
     * Read-Only access to the list of constraints learned and not deleted so
     * far in the solver. Note that for efficiency reason, the real list of
     * constraints managed by the solver is returned. DO NOT MODIFY THAT LIST
     * NOR ITS CONSTRAINTS.
     * 
     * @return the constraints learned and kept so far by the solver.
     */
    IVec<? extends IConstr> getLearnedConstraints();

    /**
     * Read-Only access to the number of variables declared in the solver.
     * 
     * @return the maximum variable id (Dimacs format) reserved in the solver.
     */
    int nVars();
}
