import React from 'react';
import './PersoanaComponent.css'
class SearchBar extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            searchTerm: ''
        };
    }

    render() {
        return (
            <div  >
                <form className="center2 " >

                    <input
                        type="text"
                        placeholder="Search..."
                        value={this.state.searchTerm}
                        onChange={event => this.setState({ searchTerm: event.target.value })}
                    />
                    <button type="submit">Search</button>
                </form>
            </div>
        );
    }
}

export default SearchBar;
