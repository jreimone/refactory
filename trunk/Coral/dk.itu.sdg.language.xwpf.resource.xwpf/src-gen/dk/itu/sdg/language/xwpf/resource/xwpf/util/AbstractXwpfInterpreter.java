/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package dk.itu.sdg.language.xwpf.resource.xwpf.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractXwpfInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfInterpreterListener> listeners = new java.util.ArrayList<dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof dk.itu.sdg.language.xwpf.Content) {
			result = interprete_dk_itu_sdg_language_xwpf_Content((dk.itu.sdg.language.xwpf.Content) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Document) {
			result = interprete_dk_itu_sdg_language_xwpf_Document((dk.itu.sdg.language.xwpf.Document) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.BodyElement) {
			result = interprete_dk_itu_sdg_language_xwpf_BodyElement((dk.itu.sdg.language.xwpf.BodyElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Comment) {
			result = interprete_dk_itu_sdg_language_xwpf_Comment((dk.itu.sdg.language.xwpf.Comment) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Footnote) {
			result = interprete_dk_itu_sdg_language_xwpf_Footnote((dk.itu.sdg.language.xwpf.Footnote) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Footer) {
			result = interprete_dk_itu_sdg_language_xwpf_Footer((dk.itu.sdg.language.xwpf.Footer) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Header) {
			result = interprete_dk_itu_sdg_language_xwpf_Header((dk.itu.sdg.language.xwpf.Header) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Hyperlink) {
			result = interprete_dk_itu_sdg_language_xwpf_Hyperlink((dk.itu.sdg.language.xwpf.Hyperlink) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Numbering) {
			result = interprete_dk_itu_sdg_language_xwpf_Numbering((dk.itu.sdg.language.xwpf.Numbering) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.PictureData) {
			result = interprete_dk_itu_sdg_language_xwpf_PictureData((dk.itu.sdg.language.xwpf.PictureData) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Paragraph) {
			result = interprete_dk_itu_sdg_language_xwpf_Paragraph((dk.itu.sdg.language.xwpf.Paragraph) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Table) {
			result = interprete_dk_itu_sdg_language_xwpf_Table((dk.itu.sdg.language.xwpf.Table) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Run) {
			result = interprete_dk_itu_sdg_language_xwpf_Run((dk.itu.sdg.language.xwpf.Run) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Part) {
			result = interprete_dk_itu_sdg_language_xwpf_Part((dk.itu.sdg.language.xwpf.Part) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof dk.itu.sdg.language.xwpf.Body) {
			result = interprete_dk_itu_sdg_language_xwpf_Body((dk.itu.sdg.language.xwpf.Body) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Sentence) {
			result = interprete_org_devboost_stanford_language_Sentence((org.devboost.stanford.language.Sentence) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.CC) {
			result = interprete_org_devboost_stanford_language_CC((org.devboost.stanford.language.CC) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.CD) {
			result = interprete_org_devboost_stanford_language_CD((org.devboost.stanford.language.CD) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.DT) {
			result = interprete_org_devboost_stanford_language_DT((org.devboost.stanford.language.DT) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.EX) {
			result = interprete_org_devboost_stanford_language_EX((org.devboost.stanford.language.EX) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.FW) {
			result = interprete_org_devboost_stanford_language_FW((org.devboost.stanford.language.FW) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.IN) {
			result = interprete_org_devboost_stanford_language_IN((org.devboost.stanford.language.IN) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.JJ) {
			result = interprete_org_devboost_stanford_language_JJ((org.devboost.stanford.language.JJ) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.JJR) {
			result = interprete_org_devboost_stanford_language_JJR((org.devboost.stanford.language.JJR) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.JJS) {
			result = interprete_org_devboost_stanford_language_JJS((org.devboost.stanford.language.JJS) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.LS) {
			result = interprete_org_devboost_stanford_language_LS((org.devboost.stanford.language.LS) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.MD) {
			result = interprete_org_devboost_stanford_language_MD((org.devboost.stanford.language.MD) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.NN) {
			result = interprete_org_devboost_stanford_language_NN((org.devboost.stanford.language.NN) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.NNS) {
			result = interprete_org_devboost_stanford_language_NNS((org.devboost.stanford.language.NNS) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.NNP) {
			result = interprete_org_devboost_stanford_language_NNP((org.devboost.stanford.language.NNP) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.NNPS) {
			result = interprete_org_devboost_stanford_language_NNPS((org.devboost.stanford.language.NNPS) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.PDT) {
			result = interprete_org_devboost_stanford_language_PDT((org.devboost.stanford.language.PDT) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.POS) {
			result = interprete_org_devboost_stanford_language_POS((org.devboost.stanford.language.POS) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.PRP) {
			result = interprete_org_devboost_stanford_language_PRP((org.devboost.stanford.language.PRP) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.PRPS) {
			result = interprete_org_devboost_stanford_language_PRPS((org.devboost.stanford.language.PRPS) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.RB) {
			result = interprete_org_devboost_stanford_language_RB((org.devboost.stanford.language.RB) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.RBR) {
			result = interprete_org_devboost_stanford_language_RBR((org.devboost.stanford.language.RBR) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.RBS) {
			result = interprete_org_devboost_stanford_language_RBS((org.devboost.stanford.language.RBS) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.RP) {
			result = interprete_org_devboost_stanford_language_RP((org.devboost.stanford.language.RP) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.SYM) {
			result = interprete_org_devboost_stanford_language_SYM((org.devboost.stanford.language.SYM) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.TO) {
			result = interprete_org_devboost_stanford_language_TO((org.devboost.stanford.language.TO) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.UH) {
			result = interprete_org_devboost_stanford_language_UH((org.devboost.stanford.language.UH) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.VB) {
			result = interprete_org_devboost_stanford_language_VB((org.devboost.stanford.language.VB) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.VBD) {
			result = interprete_org_devboost_stanford_language_VBD((org.devboost.stanford.language.VBD) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.VBG) {
			result = interprete_org_devboost_stanford_language_VBG((org.devboost.stanford.language.VBG) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.VBN) {
			result = interprete_org_devboost_stanford_language_VBN((org.devboost.stanford.language.VBN) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.VBP) {
			result = interprete_org_devboost_stanford_language_VBP((org.devboost.stanford.language.VBP) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.VBZ) {
			result = interprete_org_devboost_stanford_language_VBZ((org.devboost.stanford.language.VBZ) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.WDT) {
			result = interprete_org_devboost_stanford_language_WDT((org.devboost.stanford.language.WDT) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.WP) {
			result = interprete_org_devboost_stanford_language_WP((org.devboost.stanford.language.WP) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.WPS) {
			result = interprete_org_devboost_stanford_language_WPS((org.devboost.stanford.language.WPS) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.WRB) {
			result = interprete_org_devboost_stanford_language_WRB((org.devboost.stanford.language.WRB) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Word) {
			result = interprete_org_devboost_stanford_language_Word((org.devboost.stanford.language.Word) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.PlainText) {
			result = interprete_org_devboost_stanford_language_PlainText((org.devboost.stanford.language.PlainText) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dabbrev) {
			result = interprete_org_devboost_stanford_language_Dabbrev((org.devboost.stanford.language.Dabbrev) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dacomp) {
			result = interprete_org_devboost_stanford_language_Dacomp((org.devboost.stanford.language.Dacomp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dadvcl) {
			result = interprete_org_devboost_stanford_language_Dadvcl((org.devboost.stanford.language.Dadvcl) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dadvmod) {
			result = interprete_org_devboost_stanford_language_Dadvmod((org.devboost.stanford.language.Dadvmod) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dagent) {
			result = interprete_org_devboost_stanford_language_Dagent((org.devboost.stanford.language.Dagent) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Damod) {
			result = interprete_org_devboost_stanford_language_Damod((org.devboost.stanford.language.Damod) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dappos) {
			result = interprete_org_devboost_stanford_language_Dappos((org.devboost.stanford.language.Dappos) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dattr) {
			result = interprete_org_devboost_stanford_language_Dattr((org.devboost.stanford.language.Dattr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Daux) {
			result = interprete_org_devboost_stanford_language_Daux((org.devboost.stanford.language.Daux) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dauxpass) {
			result = interprete_org_devboost_stanford_language_Dauxpass((org.devboost.stanford.language.Dauxpass) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dcc) {
			result = interprete_org_devboost_stanford_language_Dcc((org.devboost.stanford.language.Dcc) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dccomp) {
			result = interprete_org_devboost_stanford_language_Dccomp((org.devboost.stanford.language.Dccomp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dcomplm) {
			result = interprete_org_devboost_stanford_language_Dcomplm((org.devboost.stanford.language.Dcomplm) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dconj) {
			result = interprete_org_devboost_stanford_language_Dconj((org.devboost.stanford.language.Dconj) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dcop) {
			result = interprete_org_devboost_stanford_language_Dcop((org.devboost.stanford.language.Dcop) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dcsubj) {
			result = interprete_org_devboost_stanford_language_Dcsubj((org.devboost.stanford.language.Dcsubj) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dcsubjpass) {
			result = interprete_org_devboost_stanford_language_Dcsubjpass((org.devboost.stanford.language.Dcsubjpass) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Ddep) {
			result = interprete_org_devboost_stanford_language_Ddep((org.devboost.stanford.language.Ddep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Ddet) {
			result = interprete_org_devboost_stanford_language_Ddet((org.devboost.stanford.language.Ddet) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Ddobj) {
			result = interprete_org_devboost_stanford_language_Ddobj((org.devboost.stanford.language.Ddobj) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dexpl) {
			result = interprete_org_devboost_stanford_language_Dexpl((org.devboost.stanford.language.Dexpl) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dinfmod) {
			result = interprete_org_devboost_stanford_language_Dinfmod((org.devboost.stanford.language.Dinfmod) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Diobj) {
			result = interprete_org_devboost_stanford_language_Diobj((org.devboost.stanford.language.Diobj) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dmark) {
			result = interprete_org_devboost_stanford_language_Dmark((org.devboost.stanford.language.Dmark) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dmwe) {
			result = interprete_org_devboost_stanford_language_Dmwe((org.devboost.stanford.language.Dmwe) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dneg) {
			result = interprete_org_devboost_stanford_language_Dneg((org.devboost.stanford.language.Dneg) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dnn) {
			result = interprete_org_devboost_stanford_language_Dnn((org.devboost.stanford.language.Dnn) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dnpadvmod) {
			result = interprete_org_devboost_stanford_language_Dnpadvmod((org.devboost.stanford.language.Dnpadvmod) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dnsubj) {
			result = interprete_org_devboost_stanford_language_Dnsubj((org.devboost.stanford.language.Dnsubj) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dnsubjpass) {
			result = interprete_org_devboost_stanford_language_Dnsubjpass((org.devboost.stanford.language.Dnsubjpass) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dnum) {
			result = interprete_org_devboost_stanford_language_Dnum((org.devboost.stanford.language.Dnum) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dnumber) {
			result = interprete_org_devboost_stanford_language_Dnumber((org.devboost.stanford.language.Dnumber) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dparataxis) {
			result = interprete_org_devboost_stanford_language_Dparataxis((org.devboost.stanford.language.Dparataxis) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dpartmod) {
			result = interprete_org_devboost_stanford_language_Dpartmod((org.devboost.stanford.language.Dpartmod) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dpcomp) {
			result = interprete_org_devboost_stanford_language_Dpcomp((org.devboost.stanford.language.Dpcomp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dpobj) {
			result = interprete_org_devboost_stanford_language_Dpobj((org.devboost.stanford.language.Dpobj) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dposs) {
			result = interprete_org_devboost_stanford_language_Dposs((org.devboost.stanford.language.Dposs) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dpossessive) {
			result = interprete_org_devboost_stanford_language_Dpossessive((org.devboost.stanford.language.Dpossessive) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dpreconj) {
			result = interprete_org_devboost_stanford_language_Dpreconj((org.devboost.stanford.language.Dpreconj) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dpredet) {
			result = interprete_org_devboost_stanford_language_Dpredet((org.devboost.stanford.language.Dpredet) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dprep) {
			result = interprete_org_devboost_stanford_language_Dprep((org.devboost.stanford.language.Dprep) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dprepc) {
			result = interprete_org_devboost_stanford_language_Dprepc((org.devboost.stanford.language.Dprepc) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dprt) {
			result = interprete_org_devboost_stanford_language_Dprt((org.devboost.stanford.language.Dprt) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dpunct) {
			result = interprete_org_devboost_stanford_language_Dpunct((org.devboost.stanford.language.Dpunct) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dpurpcl) {
			result = interprete_org_devboost_stanford_language_Dpurpcl((org.devboost.stanford.language.Dpurpcl) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dquantmod) {
			result = interprete_org_devboost_stanford_language_Dquantmod((org.devboost.stanford.language.Dquantmod) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Drcmod) {
			result = interprete_org_devboost_stanford_language_Drcmod((org.devboost.stanford.language.Drcmod) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dref) {
			result = interprete_org_devboost_stanford_language_Dref((org.devboost.stanford.language.Dref) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Drel) {
			result = interprete_org_devboost_stanford_language_Drel((org.devboost.stanford.language.Drel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dtmod) {
			result = interprete_org_devboost_stanford_language_Dtmod((org.devboost.stanford.language.Dtmod) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dxcomp) {
			result = interprete_org_devboost_stanford_language_Dxcomp((org.devboost.stanford.language.Dxcomp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dxsubj) {
			result = interprete_org_devboost_stanford_language_Dxsubj((org.devboost.stanford.language.Dxsubj) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Droot) {
			result = interprete_org_devboost_stanford_language_Droot((org.devboost.stanford.language.Droot) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Collapse) {
			result = interprete_org_devboost_stanford_language_Collapse((org.devboost.stanford.language.Collapse) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.Dependency) {
			result = interprete_org_devboost_stanford_language_Dependency((org.devboost.stanford.language.Dependency) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.devboost.stanford.language.NLPParagraph) {
			result = interprete_org_devboost_stanford_language_NLPParagraph((org.devboost.stanford.language.NLPParagraph) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Content(dk.itu.sdg.language.xwpf.Content content, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Document(dk.itu.sdg.language.xwpf.Document document, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_BodyElement(dk.itu.sdg.language.xwpf.BodyElement bodyElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Comment(dk.itu.sdg.language.xwpf.Comment comment, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Footnote(dk.itu.sdg.language.xwpf.Footnote footnote, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Footer(dk.itu.sdg.language.xwpf.Footer footer, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Header(dk.itu.sdg.language.xwpf.Header header, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Hyperlink(dk.itu.sdg.language.xwpf.Hyperlink hyperlink, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Numbering(dk.itu.sdg.language.xwpf.Numbering numbering, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_PictureData(dk.itu.sdg.language.xwpf.PictureData pictureData, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Paragraph(dk.itu.sdg.language.xwpf.Paragraph paragraph, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Table(dk.itu.sdg.language.xwpf.Table table, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Run(dk.itu.sdg.language.xwpf.Run run, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Part(dk.itu.sdg.language.xwpf.Part part, ContextType context) {
		return null;
	}
	
	public ResultType interprete_dk_itu_sdg_language_xwpf_Body(dk.itu.sdg.language.xwpf.Body body, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Sentence(org.devboost.stanford.language.Sentence sentence, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Word(org.devboost.stanford.language.Word word, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_CC(org.devboost.stanford.language.CC cC, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_CD(org.devboost.stanford.language.CD cD, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_DT(org.devboost.stanford.language.DT dT, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_EX(org.devboost.stanford.language.EX eX, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_FW(org.devboost.stanford.language.FW fW, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_IN(org.devboost.stanford.language.IN iN, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_JJ(org.devboost.stanford.language.JJ jJ, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_JJR(org.devboost.stanford.language.JJR jJR, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_JJS(org.devboost.stanford.language.JJS jJS, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_LS(org.devboost.stanford.language.LS lS, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_MD(org.devboost.stanford.language.MD mD, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_NN(org.devboost.stanford.language.NN nN, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_NNS(org.devboost.stanford.language.NNS nNS, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_NNP(org.devboost.stanford.language.NNP nNP, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_NNPS(org.devboost.stanford.language.NNPS nNPS, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_PDT(org.devboost.stanford.language.PDT pDT, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_POS(org.devboost.stanford.language.POS pOS, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_PRP(org.devboost.stanford.language.PRP pRP, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_PRPS(org.devboost.stanford.language.PRPS pRPS, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_RB(org.devboost.stanford.language.RB rB, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_RBR(org.devboost.stanford.language.RBR rBR, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_RBS(org.devboost.stanford.language.RBS rBS, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_RP(org.devboost.stanford.language.RP rP, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_SYM(org.devboost.stanford.language.SYM sYM, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_TO(org.devboost.stanford.language.TO tO, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_UH(org.devboost.stanford.language.UH uH, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_VB(org.devboost.stanford.language.VB vB, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_VBD(org.devboost.stanford.language.VBD vBD, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_VBG(org.devboost.stanford.language.VBG vBG, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_VBN(org.devboost.stanford.language.VBN vBN, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_VBP(org.devboost.stanford.language.VBP vBP, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_VBZ(org.devboost.stanford.language.VBZ vBZ, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_WDT(org.devboost.stanford.language.WDT wDT, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_WP(org.devboost.stanford.language.WP wP, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_WPS(org.devboost.stanford.language.WPS wPS, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_WRB(org.devboost.stanford.language.WRB wRB, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_PlainText(org.devboost.stanford.language.PlainText plainText, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dependency(org.devboost.stanford.language.Dependency dependency, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dabbrev(org.devboost.stanford.language.Dabbrev dabbrev, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dacomp(org.devboost.stanford.language.Dacomp dacomp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dadvcl(org.devboost.stanford.language.Dadvcl dadvcl, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dadvmod(org.devboost.stanford.language.Dadvmod dadvmod, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dagent(org.devboost.stanford.language.Dagent dagent, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Damod(org.devboost.stanford.language.Damod damod, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dappos(org.devboost.stanford.language.Dappos dappos, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dattr(org.devboost.stanford.language.Dattr dattr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Daux(org.devboost.stanford.language.Daux daux, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dauxpass(org.devboost.stanford.language.Dauxpass dauxpass, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dcc(org.devboost.stanford.language.Dcc dcc, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dccomp(org.devboost.stanford.language.Dccomp dccomp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dcomplm(org.devboost.stanford.language.Dcomplm dcomplm, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dconj(org.devboost.stanford.language.Dconj dconj, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dcop(org.devboost.stanford.language.Dcop dcop, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dcsubj(org.devboost.stanford.language.Dcsubj dcsubj, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dcsubjpass(org.devboost.stanford.language.Dcsubjpass dcsubjpass, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Ddep(org.devboost.stanford.language.Ddep ddep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Ddet(org.devboost.stanford.language.Ddet ddet, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Ddobj(org.devboost.stanford.language.Ddobj ddobj, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dexpl(org.devboost.stanford.language.Dexpl dexpl, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dinfmod(org.devboost.stanford.language.Dinfmod dinfmod, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Diobj(org.devboost.stanford.language.Diobj diobj, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dmark(org.devboost.stanford.language.Dmark dmark, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dmwe(org.devboost.stanford.language.Dmwe dmwe, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dneg(org.devboost.stanford.language.Dneg dneg, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dnn(org.devboost.stanford.language.Dnn dnn, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dnpadvmod(org.devboost.stanford.language.Dnpadvmod dnpadvmod, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dnsubj(org.devboost.stanford.language.Dnsubj dnsubj, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dnsubjpass(org.devboost.stanford.language.Dnsubjpass dnsubjpass, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dnum(org.devboost.stanford.language.Dnum dnum, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dnumber(org.devboost.stanford.language.Dnumber dnumber, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dparataxis(org.devboost.stanford.language.Dparataxis dparataxis, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dpartmod(org.devboost.stanford.language.Dpartmod dpartmod, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dpcomp(org.devboost.stanford.language.Dpcomp dpcomp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dpobj(org.devboost.stanford.language.Dpobj dpobj, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dposs(org.devboost.stanford.language.Dposs dposs, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dpossessive(org.devboost.stanford.language.Dpossessive dpossessive, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dpreconj(org.devboost.stanford.language.Dpreconj dpreconj, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dpredet(org.devboost.stanford.language.Dpredet dpredet, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dprep(org.devboost.stanford.language.Dprep dprep, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dprepc(org.devboost.stanford.language.Dprepc dprepc, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dprt(org.devboost.stanford.language.Dprt dprt, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dpunct(org.devboost.stanford.language.Dpunct dpunct, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dpurpcl(org.devboost.stanford.language.Dpurpcl dpurpcl, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dquantmod(org.devboost.stanford.language.Dquantmod dquantmod, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Drcmod(org.devboost.stanford.language.Drcmod drcmod, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dref(org.devboost.stanford.language.Dref dref, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Drel(org.devboost.stanford.language.Drel drel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dtmod(org.devboost.stanford.language.Dtmod dtmod, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dxcomp(org.devboost.stanford.language.Dxcomp dxcomp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Dxsubj(org.devboost.stanford.language.Dxsubj dxsubj, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Droot(org.devboost.stanford.language.Droot droot, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_Collapse(org.devboost.stanford.language.Collapse collapse, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_devboost_stanford_language_NLPParagraph(org.devboost.stanford.language.NLPParagraph nLPParagraph, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(dk.itu.sdg.language.xwpf.resource.xwpf.IXwpfInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
